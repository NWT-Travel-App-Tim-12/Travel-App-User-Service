package com.app.travel.service.user.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("timestamp", new Date());
        responseBody.put("status", status.value());
        responseBody.put("errors",
                ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage))
        );
        return new ResponseEntity<>(responseBody, headers, status);
    }

    @ExceptionHandler({
            MissingParameterInRequest.class,
            ObjectDoesNotExistInDb.class,
            InvalidAdditionalDataCast.class
    })
    public ResponseEntity<Object> customErrors(FieldNameBaseException exception){
        Map<String, Object> responseBody = new HashMap<>();
        var statusCode = exception.getCode() != null ? exception.getCode() : HttpStatus.BAD_REQUEST;
        responseBody.put("timestamp", new Date());
        responseBody.put("status", statusCode.value());
        var errors = new HashMap<String, String>();
        errors.put(exception.getFieldName(), exception.getMessage());
        responseBody.put("errors", errors);
        return ResponseEntity
                .status(
                        statusCode
                )
                .body(responseBody);
    }
}
