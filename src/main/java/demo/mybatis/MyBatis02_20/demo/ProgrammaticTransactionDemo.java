package demo.mybatis.MyBatis02_20.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.mybatis.MyBatis02_20.domain.Student;
import demo.mybatis.MyBatis02_20.service.StudentService;


public class ProgrammaticTransactionDemo {

    private static ApplicationContext ctx = null;

    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis02_20/applicationContext.xml");
    }

    public static void main(String[] args)
    {
        StudentService studentService = (StudentService)ctx.getBean("studentService");
        Student student = studentService.getById(11);
        student.setGrade("2016");
        int count = studentService.update(student);
        System.out.println("修改了" + count + "行。");
    }

}
