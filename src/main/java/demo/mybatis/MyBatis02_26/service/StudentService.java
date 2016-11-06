package demo.mybatis.MyBatis02_26.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.mybatis.MyBatis02_26.dao.StudentMapper;
import demo.mybatis.MyBatis02_26.domain.Student;
import org.springframework.transaction.annotation.Transactional;

//标注一个Service组件类，默认命名方式为
//把类名的首字母小写，如把StudentService
//类注册为bean后的名字是studentService
@Service
@Transactional
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
    
    public int update(final Student student)
    {
        int count = studentDao.update(student);
//        System.out.println(1 / 0);
        return count;
    }
}
