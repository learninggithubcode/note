package demo.mybatis.MyBatis02_10.mapper;


import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis02_10.domain.Teacher;
import demo.mybatis.MyBatis02_10.mapper.base.BaseMapper;

@Repository
public interface TeacherMapper extends BaseMapper {

	public Teacher getById(int id);

}
