package com.foxminded.university.ui;

public class ServletException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServletException(String message) {
        super(message);
    }

    public ServletException(Throwable cause) {
        super(cause);
    }

    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }
}
