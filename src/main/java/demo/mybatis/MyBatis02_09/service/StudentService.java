package demo.mybatis.MyBatis02_09.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import demo.mybatis.MyBatis02_09.domain.Student;
import demo.mybatis.MyBatis02_09.mapper.StudentMapper;

import javax.annotation.Resource;

/**
 * Created by zyb on 2016/10/30.
 */
//标注一个Service组件类，默认命名方式为
//把类名的首字母小写，如把StudentService
//类注册为bean后的名字是studentService
@Service
public class StudentService
{
    
//    @Autowired
//    @Qualifier("myStudentMapper")
    @Resource(name = "myStudentMapper")
    private StudentMapper studentDao;
    
    public Student getById(int id)
    {
        return this.studentDao.getById(id);
    }
    
    public void delById(int id)
    {
        int count = this.studentDao.delById(id);
        System.out.println("删除了" + count + "行。");
    }

    public void update(Student student)
    {
        this.studentDao.update(student);
    }
}
