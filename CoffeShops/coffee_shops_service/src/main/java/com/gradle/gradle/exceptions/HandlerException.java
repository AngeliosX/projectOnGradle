package com.gradle.gradle.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {FoundationDateIsExpiredException.class})
    protected ResponseEntity<Object> handleConflict(
            FoundationDateIsExpiredException ex, WebRequest request) {
        String bodyOfResponse = ex.toString();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<Object> handleExceptionInternal(
            FoundationDateIsExpiredException ex, String bodyOfResponse, HttpHeaders headers, HttpStatus badRequest, WebRequest request) {
        return null;
    }
}
