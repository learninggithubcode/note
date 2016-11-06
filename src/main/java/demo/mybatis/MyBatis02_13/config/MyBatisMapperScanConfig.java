package demo.mybatis.MyBatis02_13.config;

import demo.mybatis.MyBatis02_13.service.StudentService;
import demo.mybatis.MyBatis02_13.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zyb on 2016/11/3.
 */

@Configuration
@MapperScan("demo.mybatis.MyBatis02_13.mapper")
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
