package demo.mybatis.MyBatis04_01.service;

import demo.mybatis.MyBatis04_01.domain.Teacher;
import demo.mybatis.MyBatis04_01.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherMapper teacherDao;
	
	public Teacher getById(int id)
	{
		return this.teacherDao.getById(id);
	}
}
