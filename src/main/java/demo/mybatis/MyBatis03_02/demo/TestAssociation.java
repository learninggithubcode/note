package demo.mybatis.MyBatis03_02.demo;

import java.util.List;

import demo.mybatis.MyBatis03_02.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.mybatis.MyBatis03_02.domain.Student;
import demo.mybatis.MyBatis03_02.domain.Teacher;

public class TestAssociation {

	private static ApplicationContext ctx = null;
	
	//静态代码块，在类被初始化的时候执行，比如说第一次引用
	//类的静态变量，或者创建类的第一个实例的时候
	static
	{
		//在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
		ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis03_02/applicationContext.xml");
	}
	
	public static void main(String[] args)
	{
		StudentService studentService = (StudentService)ctx.getBean("studentService");
		Student student = studentService.getById(7);
		System.out.println("学生姓名：" + student.getName());
		System.out.println("指导教师姓名：" + student.getSupervisor().getName());
		System.out.println("指导教师研究方向：" + student.getSupervisor().getResearchArea());
		System.out.println("指导教师职称：" + student.getSupervisor().getTitle());

//		List<Student> students = studentService.getAll();
//		int i = 0, size = students.size();
//		Student student = null;
//		Teacher supervisor = null;
//		while(i < size)
//		{
//			student = students.get(i);
//			System.out.println("学生姓名：" + student.getName());
//			supervisor = student.getSupervisor();
//			if(supervisor != null)
//			{
//				System.out.println("指导教师姓名：" + supervisor.getName());
//				System.out.println("指导教师研究方向：" + supervisor.getResearchArea());
//				System.out.println("指导教师职称：" + supervisor.getTitle());
//			}
//			System.out.println("---------------------------------------");
//			i++;
//		}
	}
	
}
