package com.student.gradingSystem.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebMvc
@ComponentScan
public class CorsConfig {


    @Bean
    public FilterRegistrationBean registerCorsFilter(CorsFilter filter) {
        FilterRegistrationBean reg = new FilterRegistrationBean(filter);
        reg.setOrder(1);
        return reg;
    }


    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("*"));
        config.setAllowedHeaders(Arrays.asList("token", "Origin", "Content-Type",  "Content-Length", "X-Requested-With", "Accept","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Methods","X-Auth-Token"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);

    }

}
