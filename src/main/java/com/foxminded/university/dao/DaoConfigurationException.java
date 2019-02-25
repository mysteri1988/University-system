package com.foxminded.university.dao;

public class DaoConfigurationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DaoConfigurationException(String message) {
        super(message);
    }

    public DaoConfigurationException(Throwable cause) {
        super(cause);
    }

    public DaoConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
