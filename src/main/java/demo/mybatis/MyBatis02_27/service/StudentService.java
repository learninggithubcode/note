package demo.mybatis.MyBatis02_27.service;

import demo.mybatis.MyBatis02_27.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.mybatis.MyBatis02_27.dao.StudentMapper;

import java.sql.SQLException;

//标注一个Service组件类，默认命名方式为
//把类名的首字母小写，如把StudentService
//类注册为bean后的名字是studentService
@Service
//@Transactional(rollbackFor = {SQLException.class,RuntimeException.class})
@Transactional()
public class StudentService
{
    
    @Autowired
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
    
    public void update(final Student student) throws SQLException
    {
        int count = studentDao.update(student);
//        System.out.println(1 / 0);
//        throw new SQLException();
        throw new RuntimeException();
    }
}
