package demo.mybatis.MyBatis05_02.mapper;

import java.util.List;

import demo.mybatis.MyBatis05_02.domain.Student;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentMapper {
	
	Student getById(int id);
	
	List<Student> getAll();
	
	int add(Student student);
	
	int delById(int id);
	
	int update(Student student);

}
