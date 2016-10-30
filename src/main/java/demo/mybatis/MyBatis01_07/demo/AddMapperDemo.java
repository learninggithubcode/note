package demo.mybatis.MyBatis01_07.demo;

import java.io.IOException;
import java.io.Reader;

import demo.mybatis.MyBatis01_07.domain.Student;
import demo.mybatis.MyBatis01_07.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AddMapperDemo {

	private static SqlSessionFactory factory = null;

	//静态代码块，在类被初始化的时候执行，比如说第一次引用
	//类的静态变量，或者创建类的第一个实例的时候
	static
	{
		String resource = "mybatis/MyBatis01_07/mybatis-config.xml";
		try
		{
			//读取主配置文件
			Reader reader = Resources.getResourceAsReader(resource);
			//创建SqlSessionFactory对象
			factory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		SqlSession session = factory.openSession();
		Student student = null;
		int count = 0;

		try {
			
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			student = new Student();
			student.setGender("男");
			student.setGrade("2013");
			student.setMajor("物联网");
			student.setName("张泉");
			count = studentMapper.add(student);
				
			//提交事务，否则数据不会被
			//添加到数据库中
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//保证不管有没有发生异常，
			//SqlSession实例都能够被关闭，
			//以释放它占用的资源
			session.close();
		}
		
		System.out.println("学生ID：" + student.getId());
		System.out.println("添加了" + count + "行。");
		
	}
	
}
