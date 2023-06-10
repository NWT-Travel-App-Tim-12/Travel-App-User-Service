package com.app.travel.service.user.config;


import com.app.travel.service.events.LoggingRequest;
import com.app.travel.service.events.LoggingResponse;
import com.app.travel.service.events.LoggingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;


public class LoggingInterceptorAgency implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(LoggingInterceptorUser.class);

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            @Nullable Exception ex) throws Exception {
        log.info(new Timestamp((new Date()).getTime()).toString() + " " +  response.getStatus()+" " + " - User microservice - " + "Agency resource - " + request.getMethod()); // log both good and bad status codes

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8087)
                .usePlaintext()
                .build();

        LoggingServiceGrpc.LoggingServiceBlockingStub stub
                = LoggingServiceGrpc.newBlockingStub(channel);



        LoggingResponse helloResponse = stub.log(LoggingRequest.newBuilder()
                        .setTimestamp(new Timestamp((new Date()).getTime()).toString())
                        .setMicroserviceName("User microservice")
                        .setResourceName("Agency resource")
                        .setStatusCode(response.getStatus()+"")
                        .setActionType(request.getMethod())
                .build());



        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();



    }


}