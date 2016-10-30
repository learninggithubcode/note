package demo.mybatis.MyBatis02_03.dao;

import demo.mybatis.MyBatis02_03.mapper.StudentMapper;
import org.mybatis.spring.SqlSessionTemplate;

import demo.mybatis.MyBatis02_03.domain.Student;

/**
 * Created by zyb on 2016/10/30.
 */
public class StudentDao2
{
    private SqlSessionTemplate sqlSessionTemplate;

    private StudentMapper studentMapper;
    
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    private StudentMapper getStudentMapper()
    {
        return this.sqlSessionTemplate.getMapper(StudentMapper.class);
    }

    //根据id查找学生
    public Student getById(int id)
    {
        return getStudentMapper().getById(id);
    }
    
    //根据id删除学生，返回删除的行数
    public int delById(int id)
    {
        return getStudentMapper().delById(id);
    }
}
