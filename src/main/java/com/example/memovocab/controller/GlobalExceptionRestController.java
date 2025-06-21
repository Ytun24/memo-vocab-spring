package com.example.memovocab.controller;

import com.example.memovocab.exception.InternalException;
import com.example.memovocab.exception.NotFoundException;
import com.example.memovocab.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> exceptionNotFoundHandler(Exception exception) {
        log.info("Message: {}, Error: {}", exception.getMessage(), exception.getCause());
        ErrorResponse response = new ErrorResponse(1001, exception.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<ErrorResponse> exceptionInternalHandler(Exception exception) {
        log.error("Message: {}, Error: {}", exception.getMessage(), exception.getCause());
        ErrorResponse response = new ErrorResponse(1000, exception.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

