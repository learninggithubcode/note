package demo.mybatis.MyBatis01_06.demo;

import java.io.IOException;
import java.io.Reader;

import demo.mybatis.MyBatis01_06.domain.Student;
import demo.mybatis.MyBatis01_06.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MapperDemo1 {

	private static SqlSessionFactory factory = null;

	//静态代码块，在类被初始化的时候执行，比如说第一次引用
	//类的静态变量，或者创建类的第一个实例的时候
	static
	{
		String resource = "mybatis/MyBatis01_06/mybatis-config.xml";
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

		try {
			
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			student = studentMapper.getById(7);
		
			//提交事务（查询可以不提交事务）
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
		
		System.out.println("学生姓名：" + student.getName());
	}
	
}
