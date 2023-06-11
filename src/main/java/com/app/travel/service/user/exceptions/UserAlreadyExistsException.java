package com.app.travel.service.user.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends RuntimeException{
    @Getter
    private HttpStatus code;


    public UserAlreadyExistsException(String exception, HttpStatus code){
        super(exception);
        this.code=code;
    }


}
