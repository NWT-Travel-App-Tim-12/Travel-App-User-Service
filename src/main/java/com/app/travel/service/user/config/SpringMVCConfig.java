package com.app.travel.service.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;






@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(new LoggingInterceptorUser()).addPathPatterns("/users");
        interceptorRegistry.addInterceptor(new LoggingInterceptorAgency()).addPathPatterns("/agencies");
    }
}
