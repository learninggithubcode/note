package demo.mybatis.MyBatis05_04.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.mybatis.MyBatis05_04.domain.Teacher;
import demo.mybatis.MyBatis05_04.service.TeacherService;

public class ParamDemo
{
    
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis05_04/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        TeacherService teacherService = (TeacherService)ctx.getBean("teacherService");
        Teacher teacher = new Teacher();
        teacher.setGender("男");
        List<Teacher> teachers = teacherService.findTeacherByPage(teacher, "title", "asc", 0, 3);
        if (teachers.isEmpty())
        {
            System.out.println("未查询到相关教师");
        }
        for (Teacher t : teachers)
        {
            System.out.println("教师名称：" + t.getName());
			System.out.println("教师职位：" + t.getTitle());
            System.out.println("------------------------------------");
        }
    }
    
}
