package com.hand.api.controller;

import com.hand.infra.util.ServerResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ServerResponse<Object> constraintViolationExceptionHandle(ConstraintViolationException exception) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<?> item : exception.getConstraintViolations()) {
            stringBuilder.append(item.getMessage()).append(";");
        }

        return ServerResponse.createError(3, stringBuilder.substring(0, stringBuilder.length() - 1));
    }

    @ExceptionHandler(BindException.class)
    public ServerResponse<Object> bindExceptionHandle(BindException exception) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : exception.getAllErrors()) {
            stringBuilder.append(error.getDefaultMessage()).append(";");
        }

        return ServerResponse.createError(3, stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}

