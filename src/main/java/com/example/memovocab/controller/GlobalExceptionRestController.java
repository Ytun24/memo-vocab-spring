package com.example.memovocab.controller;

import com.example.memovocab.exception.NotFoundException;
import com.example.memovocab.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> exceptionNotFoundHandler(Exception exception) {
        log.info("Message: {}, Error: {}", exception.getMessage(), exception);
        ErrorResponse response = new ErrorResponse(1001, exception.getMessage());
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> exceptionBadRequestHandler(Exception exception) {
        log.info("Message: {}, Error: {}", exception.getMessage(), exception);
        ErrorResponse response = new ErrorResponse(1002, "Invalid request");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                log.info("Message: {}, Error: {}", ex.getMessage(), ex);
                ErrorResponse response = new ErrorResponse(1002, "Invalid request");
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}

