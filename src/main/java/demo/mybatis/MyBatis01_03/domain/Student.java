package demo.mybatis.MyBatis01_03.domain;

import org.apache.ibatis.type.Alias;

// 指定别名 在mapper中使用
@Alias("stu")
public class Student
{
    
    private Integer id;//主键
    
    private String name; //姓名
    
    private String gender;//性别
    
    private String major;//专业
    
    private String grade;//年级
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public String getMajor()
    {
        return major;
    }
    
    public void setMajor(String major)
    {
        this.major = major;
    }
    
    public String getGrade()
    {
        return grade;
    }
    
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    
}
