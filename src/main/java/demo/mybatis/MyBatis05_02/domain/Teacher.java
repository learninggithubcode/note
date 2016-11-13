package demo.mybatis.MyBatis05_02.domain;

import java.util.List;

public class Teacher
{
    
    private Integer id; //id
    
    private String name; //姓名 
    
    private String gender; //性别
    
    private String researchArea;//研究领域
    
    private String title; //职称
    
    private List<Student> supStudents; // 指导学生

    public List<Student> getSupStudents()
    {
        return supStudents;
    }

    public void setSupStudents(List<Student> supStudents)
    {
        this.supStudents = supStudents;
    }
    
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
    
    public String getResearchArea()
    {
        return researchArea;
    }
    
    public void setResearchArea(String researchArea)
    {
        this.researchArea = researchArea;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
}