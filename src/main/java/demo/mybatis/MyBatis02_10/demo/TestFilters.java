package demo.mybatis.MyBatis02_10.demo;

import demo.mybatis.MyBatis02_10.domain.Student;
import demo.mybatis.MyBatis02_10.domain.Teacher;
import demo.mybatis.MyBatis02_10.mapper.StudentMapper;
import demo.mybatis.MyBatis02_10.mapper.TeacherMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zyb on 2016/10/30.
 */
public class TestFilters
{
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis02_10/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        //StudentMapper studentMapper = (StudentMapper)ctx.getBean("myStudentMapper");
        StudentMapper studentMapper = (StudentMapper)ctx.getBean("studentMapper");
        Student student = studentMapper.getById(13);
        System.out.println(student.getName());

        TeacherMapper teacherMapper = (TeacherMapper)ctx.getBean("teacherMapper");
        Teacher teacher = teacherMapper.getById(1);
        System.out.println(teacher.getName());
    }
}
