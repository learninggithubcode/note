package demo.mybatis.MyBatis01_01.demo;

import java.io.IOException;
import java.io.Reader;

import demo.mybatis.MyBatis01_01.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AddDemo
{
    
    private static SqlSessionFactory factory = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        String resource = "mybatis/MyBatis01_01/mybatis-config.xml";
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
        int count = 0;
        Student student = new Student();
        
        try
        {
            student.setGender("男");
            student.setGrade("2013");
            student.setMajor("计算机科学与技术");
            student.setName("李力");

            // 命名空间.sql语句的id
            count = session.insert("demo.mybatis.MyBatis01_01.mapper.StudentMapper.add", student);
            
            //提交事务，否则数据不会被真正插入到表中
            session.commit();
        }
        catch (Exception e)
        {
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
        
        System.out.print("插入了" + count + "条记录。");
        System.out.println(student.getId());
    }
    
}
