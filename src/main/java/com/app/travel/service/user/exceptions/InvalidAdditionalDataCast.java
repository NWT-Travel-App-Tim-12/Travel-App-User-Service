package com.app.travel.service.user.exceptions;

public class InvalidAdditionalDataCast extends FieldNameBaseException{
    public InvalidAdditionalDataCast(String message) {
        super(message, "additional_data");
    }
}
