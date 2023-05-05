package com.app.travel.service.user.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;






@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(loggingInterceptor);
    }
}
