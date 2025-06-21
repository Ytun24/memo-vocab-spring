package com.example.memovocab.exception;

public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable err) {
        super(message, err);
    }
}
