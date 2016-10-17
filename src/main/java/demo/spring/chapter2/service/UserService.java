package demo.spring.chapter2.service;

import demo.spring.chapter2.dao.LoginLogDao;
import demo.spring.chapter2.dao.UserDao;
import demo.spring.chapter2.domain.LoginLog;
import demo.spring.chapter2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 益波 on 2016/10/1.
 */
@Service
public class UserService
{
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private LoginLogDao loginLogDao;
    
    public boolean hasMatchUser(String userName, String paaword)
    {
        int matchCount = userDao.getMatchCount(userName, paaword);
        return matchCount > 0;
    }
    
    public User findUserByUserName(String userName)
    {
        return userDao.findUserByUserName(userName);
    }
    
    public void loginSuccess(User user)
    {
        user.setCredits(5 + user.getCredits());
        userDao.updateLoginInfo(user);
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLogDao.insertLoginLog(loginLog);
    }
}
