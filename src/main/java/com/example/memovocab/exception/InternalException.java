package com.example.memovocab.exception;

public class InternalException extends RuntimeException {

    public InternalException(String message) {
        super(message);
    }

    public InternalException(String message, Throwable err) {
        super(message, err);
    }
}
