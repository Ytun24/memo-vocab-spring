package com.example.memovocab.exception;

import com.example.memovocab.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> exceptionInternalHandler(Exception exception) {
        log.error("Message: {}, Error: {}", exception.getMessage(), exception);
        ErrorResponse response = new ErrorResponse(1000, "Internal server error");
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
