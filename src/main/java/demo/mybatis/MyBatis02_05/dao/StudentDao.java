package demo.mybatis.MyBatis02_05.dao;

import org.springframework.stereotype.Repository;

import demo.mybatis.MyBatis02_05.domain.Student;
import demo.mybatis.MyBatis02_05.mapper.StudentMapper;

/**
 * Created by zyb on 2016/10/30.
 */
@Repository //用于标注一个DAO类
public class StudentDao extends BaseDao<StudentMapper>
{
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

    public void update(Student student)
    {
        int count = this.mapper.update(student);
        System.out.println("成功更新了 " + count + "行");
    }
}
