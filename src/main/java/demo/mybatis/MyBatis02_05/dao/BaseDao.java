package demo.mybatis.MyBatis02_05.dao;

import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zyb on 2016/10/30.
 */
public class BaseDao<T> extends SqlSessionDaoSupport
{
    protected T mapper;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @PostConstruct//让Spring在注入完依赖之后回调此方法
    public void init()
    {
        System.out.println("Initializing...");
        Class<T> mapperClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.mapper = this.getSqlSession().getMapper(mapperClass);
    }
}
