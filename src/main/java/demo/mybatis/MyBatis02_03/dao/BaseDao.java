package demo.mybatis.MyBatis02_03.dao;

import org.mybatis.spring.SqlSessionTemplate;

import demo.mybatis.MyBatis02_03.domain.Student;

/**
 * Created by zyb on 2016/10/30.
 */
public class BaseDao
{
    protected SqlSessionTemplate sqlSessionTemplate;
    
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
}
