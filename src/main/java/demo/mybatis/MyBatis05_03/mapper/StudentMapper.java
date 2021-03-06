package demo.mybatis.MyBatis05_03.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis05_03.domain.Student;


@Repository
public interface StudentMapper {
	
	Student getById(int id);
	
	List<Student> getAll();
	
	int add(Student student);
	
	int delById(int id);
	
	int update(Student student);

}
