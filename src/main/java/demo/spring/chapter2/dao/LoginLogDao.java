package demo.spring.chapter2.dao;

import demo.spring.chapter2.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by 益波 on 2016/10/1.
 */
@Repository
public class LoginLogDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void insertLoginLog(LoginLog loginLog)
    {
        String sql = "insert into t_login_log(user_id, ip, login_datetime) values(?,?,?)";
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(sql, args);
    }
}
