package demo.mybatis.MyBatis03_01.mapper;

import demo.mybatis.MyBatis03_01.domain.Teacher;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherMapper {
		
	public Teacher getById(int id);

}
