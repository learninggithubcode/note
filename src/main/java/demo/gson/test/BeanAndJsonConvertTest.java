package demo.gson.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import demo.gson.entity.Book;
import demo.gson.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanAndJsonConvertTest
{
    public static void main(String[] args)
    {
        
        Student stu = createStuden();
        
        // Gson类：解析json的最基础的工具类
        Gson gson = new Gson();
        
        // bean --> json
        String json = gson.toJson(stu);
        System.out.println("bean->json: " + json);
        
        // json --> bean
        Student s = gson.fromJson(json, Student.class);
        System.out.println("json->bean: " + s);
        
        // 将json转换成复杂类型的bean,需要使用TypeToken
        // 将json转换成List
        String listJson =
            "[{\"id\":\"BZ001\",\"name\":\"Java开发指南\",\"isNew\":false},{\"id\":\"BZ002\",\"name\":\"SQL权威指南\",\"isNew\":true},{\"id\":\"BZ003\",\"name\":\"Spring开发指南\",\"isNew\":false}]";
        List list = gson.fromJson(listJson, new TypeToken<List>()
        {
        }.getType());
        
    }
    
    private static Student createStuden()
    {
        Student stu = new Student();
        stu.setName("张益波");
        stu.setAge(26);
        stu.setDescribe("一个安静的美男子");
        stu.setSex("男");
        List<Book> books = new ArrayList<>();
        books.add(new Book("BZ001", "Java开发指南", false));
        books.add(new Book("BZ002", "SQL权威指南", true));
        books.add(new Book("BZ003", "Spring开发指南", false));
        stu.setBooks(books);
        return stu;
    }
    
    public static boolean isMobile(String str)
    {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}
