package demo.mybatis.MyBatis02_01.demo;

import demo.mybatis.MyBatis02_01.domain.Student;
import demo.mybatis.MyBatis02_01.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SqlSessionFactoryDemo
{
    
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:/mybatis/MyBatis02_01/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)ctx.getBean("sqlSessionFactory");
        System.out.println(sqlSessionFactory.getClass());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = null;
        
        try
        {
            studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = studentMapper.getById(11);
            System.out.println("姓名：" + student.getName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            sqlSession.close();
        }
    }
    
}
