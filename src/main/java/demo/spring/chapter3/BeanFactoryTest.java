package demo.spring.chapter3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by 益波 on 2016/10/3.
 */
public class BeanFactoryTest
{
    public static void main(String[] args)
        throws Exception
    {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:spring-3.xml");
        //        Resource resource = resolver.getResource("file:C:\\Users\\益波\\IdeaProjects\\note\\note\\src\\main\\resources\\spring\\chapter3\\spring-3.xml");
        System.out.println("resource: " + resource);
        BeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("init bean factory");
        
        Car car = (Car)factory.getBean("car");
        System.out.println("car: " + car);
    }
}
