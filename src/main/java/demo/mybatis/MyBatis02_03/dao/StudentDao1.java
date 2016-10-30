package demo.mybatis.MyBatis02_03.dao;

import demo.mybatis.MyBatis02_03.domain.Student;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by zyb on 2016/10/30.
 */
public class StudentDao1
{
    private String namespace = "demo.mybatis.MyBatis02_03.mapper.StudentMapper.";
    
    private SqlSessionTemplate sqlSessionTemplate;
    
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    //根据id查找学生
    public Student getById(int id)
    {
        return this.sqlSessionTemplate.selectOne(namespace + "getById", id);
    }
    
    //根据id删除学生，返回删除的行数
    public int delById(int id)
    {
        return this.sqlSessionTemplate.delete(namespace + "delById", id);
    }
}
