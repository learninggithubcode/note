package demo.mybatis.MyBatis03_02.mapper;

import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis03_02.domain.Teacher;


@Repository
public interface TeacherMapper {
		
	public Teacher getById(int id);

}
