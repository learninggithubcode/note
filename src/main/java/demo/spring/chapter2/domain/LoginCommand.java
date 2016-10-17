package demo.spring.chapter2.domain;

/**
 * Created by 益波 on 2016/10/2.
 */
public class LoginCommand
{
    private String userName;

    private String password;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
