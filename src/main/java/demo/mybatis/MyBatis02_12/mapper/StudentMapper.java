package demo.mybatis.MyBatis02_12.mapper;


import java.util.List;

import demo.mybatis.MyBatis02_12.domain.Student;

public interface StudentMapper {
	
	public Student getById(int id);
	
	public List<Student> getAll();
	
	public int add(Student student);
	
	public int delById(int id);
	
	public int update(Student student);

}
