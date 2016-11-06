package demo.mybatis.MyBatis02_17.service;

import org.springframework.beans.factory.annotation.Autowired;

import demo.mybatis.MyBatis02_17.domain.Teacher;
import demo.mybatis.MyBatis02_17.mapper.TeacherMapper;

/**
 * Created by zyb on 2016/10/30.
 */
//标注一个Service组件类，默认命名方式为
//把类名的首字母小写，如把StudentService
//类注册为bean后的名字是studentService
//@Service
public class TeacherService
{
    
    @Autowired
    private TeacherMapper teacherMapper;
    
    public Teacher getById(int id)
    {
        return this.teacherMapper.getById(id);
    }
}
