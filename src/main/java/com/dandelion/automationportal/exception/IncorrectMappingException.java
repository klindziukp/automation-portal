package com.dandelion.automationportal.exception;

public class IncorrectMappingException extends RuntimeException {

    public IncorrectMappingException(String message) {
        super(message);
    }

    public IncorrectMappingException(Throwable cause) {
        super(cause);
    }

    public IncorrectMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectMappingException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
