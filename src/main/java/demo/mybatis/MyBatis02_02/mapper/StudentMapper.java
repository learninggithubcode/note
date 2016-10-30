package demo.mybatis.MyBatis02_02.mapper;


import demo.mybatis.MyBatis02_02.domain.Student;

import java.util.List;

public interface StudentMapper {
	
	public Student getById(int id);
	
	public List<Student> getAll();
	
	public int add(Student student);
	
	public int delById(int id);
	
	public int update(Student student);

}
