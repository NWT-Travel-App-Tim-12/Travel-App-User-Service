package com.app.travel.service.user.config;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoggingInterceptorUser implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(LoggingInterceptorUser.class);

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable Exception ex) throws Exception {
        log.info(response.getStatus()+" " + " - User microservice - " + "User resource - " + request.getMethod()); // log both good and bad status codes
    }


}
