package demo.mybatis.MyBatis02_26.config;

import demo.mybatis.MyBatis02_26.dao.Maker1;
import demo.mybatis.MyBatis02_26.mapper.Maker2;
import demo.mybatis.MyBatis02_26.service.StudentService;
import demo.mybatis.MyBatis02_26.service.TeacherService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zyb on 2016/11/3.
 */

@Configuration
//@MapperScan(basePackages = {"demo.mybatis.MyBatis02_16.mapper", "demo.mybatis.MyBatis02_5.dao"}, sqlSessionTemplateRef = "sqlSessionTemplate")
@MapperScan(basePackageClasses = {Maker2.class, Maker1.class})
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
