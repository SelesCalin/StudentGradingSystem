package com.student.gradingSystem.util.filter;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean< BasicFilter > filterRegistrationBean() {
        FilterRegistrationBean < BasicFilter > registrationBean = new FilterRegistrationBean<>();
        BasicFilter basicFilter= new BasicFilter();

        registrationBean.setFilter(basicFilter);
        registrationBean.addUrlPatterns("/test/*");
        return registrationBean;
    }


    @Bean
    public FilterRegistrationBean<AdminFilter>  adminFilterFilterRegistrationBean(){
        FilterRegistrationBean<AdminFilter> adminFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        AdminFilter adminFilter = new AdminFilter();

        adminFilterFilterRegistrationBean.setFilter(adminFilter);
        adminFilterFilterRegistrationBean.addUrlPatterns("/admin/*");
        return adminFilterFilterRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean<StudentFilter> studentFilterFilterRegistrationBean(){
        FilterRegistrationBean<StudentFilter> studentFilterFilterRegistrationBean= new FilterRegistrationBean<>();
        StudentFilter studentFilter= new StudentFilter();

        studentFilterFilterRegistrationBean.setFilter(studentFilter);
        studentFilterFilterRegistrationBean.addUrlPatterns("/student/*");
        return studentFilterFilterRegistrationBean;

    }


    @Bean
    public FilterRegistrationBean<TeacherFilter> teacherFilterFilterRegistrationBean(){
        FilterRegistrationBean<TeacherFilter> teacherFilterFilterRegistrationBean= new FilterRegistrationBean<>();
        TeacherFilter teacherFilter=new TeacherFilter();

        teacherFilterFilterRegistrationBean.setFilter(teacherFilter);
        teacherFilterFilterRegistrationBean.addUrlPatterns("/teacher/*");
        return teacherFilterFilterRegistrationBean;
    }
}
