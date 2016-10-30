package demo.mybatis.MyBatis02_04_1.dao;

import demo.mybatis.MyBatis02_04_1.domain.Student;
import demo.mybatis.MyBatis02_04_1.mapper.StudentMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by zyb on 2016/10/30.
 */
@Repository//用于标注一个DAO类
public class StudentDao extends BaseDao {

    //根据id查找学生
    public Student getById(int id)
    {
        return this.getMapper().getById(id);
    }

    //根据id删除学生，返回删除的行数
    public int delById(int id)
    {
        return this.getMapper().delById(id);
    }

    private StudentMapper getMapper()
    {
        return this.getSqlSession().getMapper(StudentMapper.class);
    }
}
