package demo.mybatis.MyBatis05_05.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.mybatis.MyBatis05_05.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mybatis.MyBatis05_05.mapper.TeacherMapper;

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
    
//    public List<Teacher> findTeacherByPage(String sort, String dir, int start, int limit)
//    {
//        return this.teacherDao.findTeacherByPage(sort, dir, start, limit);
//    }

    public List<Teacher> findTeacherByPage(Teacher teacher, String sort, String dir, int start, int limit)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("sort", sort);
        params.put("dir", dir);
        params.put("gender", teacher.getGender());
        return this.teacherDao.findTeacherByPage(params, start, limit);
    }
}
