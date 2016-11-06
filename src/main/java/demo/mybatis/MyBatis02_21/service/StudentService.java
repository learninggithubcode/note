package demo.mybatis.MyBatis02_21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import demo.mybatis.MyBatis02_21.dao.StudentMapper;
import demo.mybatis.MyBatis02_21.domain.Student;

//标注一个Service组件类，默认命名方式为
//把类名的首字母小写，如把StudentService
//类注册为bean后的名字是studentService
@Service
public class StudentService
{
    
    @Autowired
    private TransactionTemplate txTemplate;
    
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
        return this.txTemplate.execute(new TransactionCallback<Integer>()
        {
            @Override
            public Integer doInTransaction(TransactionStatus status)
            {
                int count = 0;
                try
                {
                    count = studentDao.update(student);
                }
                catch (RuntimeException e)
                {
                    e.printStackTrace();
                    count = 0;
                    //回滚事务
                    status.setRollbackOnly();
                }
                
                return count;
            }
        });
    }
}
