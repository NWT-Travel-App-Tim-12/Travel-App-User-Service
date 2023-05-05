package com.app.travel.service.user.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;



public class LoggingInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);


    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("ahmedoni");
        log.info(response.getStatus()+"");
    }


}
