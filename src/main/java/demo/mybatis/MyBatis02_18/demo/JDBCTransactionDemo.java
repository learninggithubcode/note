package demo.mybatis.MyBatis02_18.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCTransactionDemo
{
    
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis02_18/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        Connection con = null;
        PreparedStatement st = null;
        Savepoint savepoint = null;
        try
        {
            con = dataSource.getConnection();
            //禁止Connection自动提交
            con.setAutoCommit(false);
            //设置事务隔离级别
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            st = con.prepareStatement("delete from student where id=1");
            st.executeUpdate();
            //若回滚到此保存点，则仍然可以提交事务，
            //事务提交后，保存点以前的操作会被提交，以后的操作会被回滚
            savepoint = con.setSavepoint();
            st = con.prepareStatement("update student set grade=? where id=11");
            st.setString(1, "2014");
            st.executeUpdate();
            int a = 1 / 0;
            System.out.println(a);
            con.commit();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try
            {
                //回滚整个事务
                con.rollback();
            }
            catch (SQLException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
            try
            {
                if (savepoint != null)
                {
                    //回滚到savepoint保存点
                    con.rollback(savepoint);
                    con.commit();
                }
                else
                {
                    //回滚整个事务
                    con.rollback();
                }
                
            }
            catch (SQLException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
        }
        finally
        {
            try
            {
                if (st != null)
                {
                    st.close();
                }
                
                if (con != null)
                {
                    con.close();
                }
            }
            catch (SQLException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }
    
}
