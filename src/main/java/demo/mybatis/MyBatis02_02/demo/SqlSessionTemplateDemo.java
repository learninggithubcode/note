package demo.mybatis.MyBatis02_02.demo;

import demo.mybatis.MyBatis02_02.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.mybatis.MyBatis02_02.domain.Student;

public class SqlSessionTemplateDemo
{
    
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:/mybatis/MyBatis02_02/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        SqlSession sqlSession = (SqlSession)ctx.getBean("sqlSessionTemplate");
        Student student = new Student();
        student.setGender("男");
        student.setGrade("2014");
        student.setMajor("物联网工程");
        student.setName("李小明");

        // 第一种方式
        // sqlSession.insert("demo.mybatis.MyBatis02_02.mapper.StudentMapper.add", student);

        // 第二种方式
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.add(student);

        //不能手动调用它的commit、rollback和close方法，
        //否则会抛出 UnsupportedOperationException异常
        //sqlSession.close();

    }
    
}
