package demo.mybatis.MyBatis01_06.mapper;

import demo.mybatis.MyBatis01_06.domain.Student;

import java.util.List;

/**
 * Created by zhangyb on 2016/10/26 0026.
 */
public interface StudentMapper
{
    public Student getById(int id);

    public List<Student> getAll();
}
