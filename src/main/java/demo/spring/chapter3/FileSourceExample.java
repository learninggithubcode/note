package demo.spring.chapter3;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Created by 益波 on 2016/10/3.
 */
public class FileSourceExample
{
    public static void main(String[] args)
    {
        try
        {
            String filePath = "C:\\Users\\益波\\IdeaProjects\\note\\note\\src\\main\\resources\\log4j.properties";
            Resource resource1 = new FileSystemResource(filePath);
            Resource resource2 = new ClassPathResource("log4j.properties");

            System.out.println("resource1: " + resource1);
            System.out.println("resource2: " + resource2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
