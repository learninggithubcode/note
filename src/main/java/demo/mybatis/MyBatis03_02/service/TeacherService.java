package demo.mybatis.MyBatis03_02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mybatis.MyBatis03_02.domain.Teacher;
import demo.mybatis.MyBatis03_02.mapper.TeacherMapper;

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
