package demo.mybatis.MyBatis02_20.service;

import demo.mybatis.MyBatis02_20.dao.StudentMapper;
import demo.mybatis.MyBatis02_20.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

//标注一个Service组件类，默认命名方式为
//把类名的首字母小写，如把StudentService
//类注册为bean后的名字是studentService
@Service
public class StudentService
{
    
    @Autowired
    private PlatformTransactionManager txManager;
    
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
    
    public int update(Student student)
    {
        TransactionStatus status = null;
        int count = 0;
        try
        {
            //事务定义
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();

            def.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
            //调用 setIsolationLevelName方法也能定义隔离级别，参数是TransactionDefinition
            //接口中代表相应隔离级别的常量的名字，String类型
            //def.setIsolationLevelName("ISOLATION_SERIALIZABLE");

            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
            //调用setPropagationBehaviorName方法也能定义事务传播行为，参数是
            //TransactionDefinition接口中代表相应传播行为的常量的名字，String类型
            //def.setPropagationBehaviorName("PROPAGATION_REQUIRED");

            status = txManager.getTransaction(def);
            System.out.println("是新事务吗？  " + status.isNewTransaction());
            count = this.studentDao.update(student);
//            			int a = 1 / 0;
//            			System.out.println(a);
        }
        catch (RuntimeException e)
        {
            txManager.rollback(status);
            System.out.println("回滚后，是否已完成？" + status.isCompleted());
            count = 0;
            return count;
        }
        
        txManager.commit(status);
        System.out.println("提交后，是否已完成？" + status.isCompleted());
        return count;
    }
}
