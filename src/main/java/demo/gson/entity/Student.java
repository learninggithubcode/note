package demo.gson.entity;

import java.util.List;

public class Student
{
    private String name;
    
    private int age;
    
    private String sex;
    
    private String describe;
    
    private List<Book> books;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getDescribe()
    {
        return describe;
    }
    
    public void setDescribe(String describe)
    {
        this.describe = describe;
    }
    
    public List<Book> getBooks()
    {
        return books;
    }
    
    public void setBooks(List<Book> books)
    {
        this.books = books;
    }
    
    @Override
    public String toString()
    {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", sex='" + sex + '\'' + ", describe='" + describe + '\'' + ", books=" + books + '}';
    }
}
