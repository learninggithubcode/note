package demo.spring.chapter2.dao;

import demo.spring.chapter2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 益波 on 2016/10/1.
 */
@Repository
public class UserDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int getMatchCount(String username, String password)
    {
        String sql = "SELECT count(*) from t_user where user_name=? and password=?";
        return jdbcTemplate.queryForInt(sql, new Object[] {username, password});
    }
    
    public User findUserByUserName(final String userName)
    {
        String sql = "select user_id, user_name, credits from t_user where user_name=?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[] {userName}, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet resultSet)
                throws SQLException
            {
                user.setCredits(resultSet.getInt("credits"));
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
            }
        });
        return user;
    }
    
    public void updateLoginInfo(User user)
    {
        String sql = "update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
        jdbcTemplate.update(sql, new Object[] {user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
    }
}
