package com.newer.lvyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器配置类
@Configuration  //声明为配置类
public class InterceptiorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //“/**”代表多层的任意路径   excludePathPatterns 不拦截的可以放这里
        registry.addInterceptor(createInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/drawTable","/api/loginTest1","/api/img","/api/findBynamePassword","/api/getAdmin");


    }

    @Bean
    public MyInterceptor createInterceptor(){
        return new MyInterceptor();
    }

}


