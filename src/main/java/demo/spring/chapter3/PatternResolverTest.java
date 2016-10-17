package demo.spring.chapter3;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by 益波 on 2016/10/3.
 */
public class PatternResolverTest
{
    public static void main(String[] args) throws Exception
    {
        // 一次获取多个资源   个人理解
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:spring/**/*.xml");
        int index = 1;
        for (Resource resource : resources)
        {
            System.out.println(index++ + ": " + resource.getDescription());
        }

        System.out.println("----------------------------------");

        Resource resource = resolver.getResource("classpath:spring/chapter3/spring-3.xml");
        System.out.println(resource.getFilename());
    }
}
