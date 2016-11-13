package demo.mybatis.MyBatis05_02.service;

import java.util.List;

import demo.mybatis.MyBatis05_02.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mybatis.MyBatis05_02.domain.Teacher;

@Service
@Transactional
public class TeacherService
{
    
    @Autowired
    private TeacherMapper teacherDao;
    
    public Teacher getById(int id)
    {
        return this.teacherDao.getById(id);
    }
    
    public List<Teacher> findTeacherByPage(String sort, String dir, int start, int limit)
    {
        return this.teacherDao.findTeacherByPage(sort, dir, start, limit);
    }
}
