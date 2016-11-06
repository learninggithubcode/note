package demo.mybatis.MyBatis02_14.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.mybatis.MyBatis02_14.service.StudentService;
import demo.mybatis.MyBatis02_14.service.TeacherService;

/**
 * Created by zyb on 2016/11/3.
 */

@Configuration
@MapperScan(basePackages = {"demo.mybatis.MyBatis02_14.mapper", "demo.mybatis.MyBatis02_14.dao"}, sqlSessionTemplateRef = "sqlSessionTemplate")
public class MyBatisMapperScanConfig
{
    @Bean
    public TeacherService getTeacherService()
    {
        return new TeacherService();
    }
    
    @Bean
    public StudentService getStudentService()
    {
        return new StudentService();
    }
}
