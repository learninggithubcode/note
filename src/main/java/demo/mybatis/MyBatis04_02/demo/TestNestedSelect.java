package demo.mybatis.MyBatis04_02.demo;

import java.util.List;

import demo.mybatis.MyBatis04_02.domain.Student;
import demo.mybatis.MyBatis04_02.domain.Teacher;
import demo.mybatis.MyBatis04_02.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestNestedSelect {

	private static ApplicationContext ctx = null;

	//静态代码块，在类被初始化的时候执行，比如说第一次引用
	//类的静态变量，或者创建类的第一个实例的时候
	static
	{
		//在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
		ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis04_02/applicationContext.xml");
	}

	public static void main(String[] args)
	{
		TeacherService teacherService = (TeacherService)ctx.getBean("teacherService");
		Teacher teacher = teacherService.getById(1);
		System.out.println("教师姓名：" + teacher.getName());
		int i = 0, size = 0;
		List<Student> students = teacher.getSupStudents();
		if(students != null)
		{
			size = students.size();
			while( i < size)
			{
				System.out.println("学生的姓名：" + students.get(i).getName());
				System.out.println("----------------------------------------");
				i++;
			}
		}
	}

}
