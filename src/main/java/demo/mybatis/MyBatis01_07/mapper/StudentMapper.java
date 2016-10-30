package demo.mybatis.MyBatis01_07.mapper;

import demo.mybatis.MyBatis01_07.domain.Student;

import java.util.List;

/**
 * Created by zhangyb on 2016/10/26 0026.
 */
public interface StudentMapper
{
    Student getById(int id);

    List<Student> getAll();

    int add(Student student);

    int delById(int id);

    int update(Student student);
}
