package com.app.travel.service.user.exceptions;

public class MissingParameterInRequest extends FieldNameBaseException{
    public MissingParameterInRequest(String message, String fieldName) {
        super(message, fieldName);
    }
}
