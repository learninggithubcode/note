package demo.mybatis.MyBatis02_10.mapper;


import java.util.List;

import demo.mybatis.MyBatis02_10.annotation.MyMapper;
import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis02_10.domain.Student;

@Repository
@MyMapper
public interface StudentMapper {
	
	public Student getById(int id);
	
	public List<Student> getAll();
	
	public int add(Student student);
	
	public int delById(int id);
	
	public int update(Student student);

}
