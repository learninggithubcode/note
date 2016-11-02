package demo.mybatis.MyBatis02_11.mapper;


import demo.mybatis.MyBatis02_11.domain.Teacher;
import demo.mybatis.MyBatis02_11.mapper.base.BaseMapper;

public interface TeacherMapper extends BaseMapper {

	public Teacher getById(int id);

}
