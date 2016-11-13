package demo.mybatis.MyBatis05_03.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.mybatis.MyBatis05_03.domain.Teacher;
import demo.mybatis.MyBatis05_03.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Teacher> findTeacherByPage(String sort, String dir, int start, int limit)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("sort", sort);
        params.put("dir", dir);
        params.put("start", start);
        params.put("limit", limit);
        return this.teacherDao.findTeacherByPage(params);
    }
}
