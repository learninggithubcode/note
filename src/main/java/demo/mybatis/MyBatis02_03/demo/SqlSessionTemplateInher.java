package demo.mybatis.MyBatis02_03.demo;

import demo.mybatis.MyBatis02_03.dao.StudentDao3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.mybatis.MyBatis02_03.dao.StudentDao1;
import demo.mybatis.MyBatis02_03.domain.Student;

public class SqlSessionTemplateInher
{
    
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:/mybatis/MyBatis02_03/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        StudentDao3 studentDao3 = (StudentDao3)ctx.getBean("studentDao3");
        Student student = studentDao3.getById(11);
        System.out.println("学生姓名： " + student.getName());
        
        int count = studentDao3.delById(15);
        System.out.println("删除了" + count + "行。");
        
    }
    
}
