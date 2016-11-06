package demo.mybatis.MyBatis02_15.config;

import demo.mybatis.MyBatis02_15.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.mybatis.MyBatis02_15.service.StudentService;

/**
 * Created by zyb on 2016/11/3.
 */

@Configuration
//@MapperScan(basePackages = {"demo.mybatis.MyBatis02_15.mapper", "demo.mybatis.MyBatis02_5.dao"}, sqlSessionTemplateRef = "sqlSessionTemplate")
@MapperScan(basePackageClasses = {demo.mybatis.MyBatis02_15.mapper.Maker2.class, demo.mybatis.MyBatis02_15.dao.Maker1.class})
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
