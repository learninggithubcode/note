package demo.mybatis.MyBatis02_17.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zyb on 2016/10/30.
 */
public class MetaDataDemo
{
    private static ApplicationContext ctx = null;
    
    //静态代码块，在类被初始化的时候执行，比如说第一次引用
    //类的静态变量，或者创建类的第一个实例的时候
    static
    {
        //在类路径下寻找spring主配置文件，相对于类的根路径，启动spring容器
        ctx = new ClassPathXmlApplicationContext("classpath:mybatis/MyBatis02_17/applicationContext.xml");
    }
    
    public static void main(String[] args)
    {
        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        try
        {
            Connection con = dataSource.getConnection();
            DatabaseMetaData metaData = con.getMetaData();
            System.out.println("是否支持事务？" + metaData.supportsTransactions());
            System.out.println("是否SERIALIZABLE隔离级别？" + metaData.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE));
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
