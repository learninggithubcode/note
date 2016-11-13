package demo.mybatis.MyBatis05_01.service;

import java.util.List;

import demo.mybatis.MyBatis05_01.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.mybatis.MyBatis05_01.mapper.StudentMapper;


//标注一个Service组件类，默认命名方式为
//把类名的首字母小写，如把StudentService
//类注册为bean后的名字是studentService
@Service
public class StudentService {

	@Autowired
	private StudentMapper studentDao;
	
	public Student getById(int id)
	{
		return this.studentDao.getById(id);
	}
	
	public void delById(int id)
	{
		int count = this.studentDao.delById(id);
		System.out.println("删除了" + count + "行。");
	}
	
	public int update(Student student)
	{
		int count = studentDao.update(student);
		return count;
	}
	
	public List<Student> getAll()
	{
		return this.studentDao.getAll();
	}


}
