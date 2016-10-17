package demo.spring.chapter3;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Created by 益波 on 2016/10/3.
 */
public class EncodedResourceExample
{
    public static void main(String[] args)
    {
        try
        {
            String filePath = "C:\\Users\\益波\\IdeaProjects\\note\\note\\src\\main\\resources\\log4j.properties";
            Resource resource1 = new FileSystemResource(filePath);
            EncodedResource encodedResource = new EncodedResource(resource1, "UTF-8");
            System.out.println(FileCopyUtils.copyToString(encodedResource.getReader()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
