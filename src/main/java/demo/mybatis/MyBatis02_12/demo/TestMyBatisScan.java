package demo.mybatis.MyBatis02_12.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.mybatis.MyBatis02_12.mapper.StudentMapper;
import demo.mybatis.MyBatis02_12.mapper.TeacherMapper;

/**
 * Created by zyb on 2016/10/30.
 */
public class TestMyBatisScan
{
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis02_12/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        StudentMapper studentMapper = (StudentMapper)ctx.getBean("studentMapper");
        System.out.println(studentMapper.getById(6).getName());

        TeacherMapper teacherMapper = (TeacherMapper)ctx.getBean("teacherMapper");
        System.out.println(teacherMapper.getById(1).getName());
    }
}
