package com.foxminded.university.service;

public class StudentServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StudentServiceException(String message) {
        super(message);
    }

    public StudentServiceException(Throwable cause) {
        super(cause);
    }

    public StudentServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
