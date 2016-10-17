package demo.spring.chapter2.test;

import demo.spring.chapter2.domain.User;
import demo.spring.chapter2.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 益波 on 2016/10/1.
 */
// 需要jar：spring-test && junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/chapter2/applicationContext.xml")
public class TestUserService
{
    @Autowired
    private UserService userService;
    
    @Test
    public void hasMatchUser()
    {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        System.out.println("hasMatchUser(\"admin\", \"123456\") : " + b1);
    }

    @Test
    public void findUserByUserName()
    {
        User user = userService.findUserByUserName("admin");
        System.out.println(user);
    }
}
