package com.example.memovocab.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable err) {
        super(message, err);
    }
}
