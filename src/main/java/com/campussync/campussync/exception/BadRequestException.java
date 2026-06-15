package com.campussync.campussync.exception;



public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}