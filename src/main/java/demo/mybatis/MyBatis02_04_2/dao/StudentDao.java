package demo.mybatis.MyBatis02_04_2.dao;

import demo.mybatis.MyBatis02_04_2.domain.Student;
import demo.mybatis.MyBatis02_04_2.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created by zyb on 2016/10/30.
 */
@Repository //用于标注一个DAO类
public class StudentDao extends BaseDao
{
    private StudentMapper mapper;

    //根据id查找学生
    public Student getById(int id)
    {
        return this.mapper.getById(id);
    }
    
    //根据id删除学生，返回删除的行数
    public int delById(int id)
    {
        return this.mapper.delById(id);
    }

    @PostConstruct//让Spring在注入完依赖之后回调此方法
    public void init()
    {
        System.out.println("Initializing...");
        this.mapper = this.getSqlSession().getMapper(StudentMapper.class);
    }
}
