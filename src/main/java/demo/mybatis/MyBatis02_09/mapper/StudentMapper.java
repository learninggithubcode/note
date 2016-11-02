package demo.mybatis.MyBatis02_09.mapper;


import java.util.List;

import demo.mybatis.MyBatis02_09.domain.Student;
import org.springframework.stereotype.Repository;

@Repository("myStudentMapper")
public interface StudentMapper {
	
	public Student getById(int id);
	
	public List<Student> getAll();
	
	public int add(Student student);
	
	public int delById(int id);
	
	public int update(Student student);

}
