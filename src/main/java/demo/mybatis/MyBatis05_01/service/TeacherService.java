package demo.mybatis.MyBatis05_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mybatis.MyBatis05_01.domain.Teacher;
import demo.mybatis.MyBatis05_01.mapper.TeacherMapper;

import java.util.List;

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
