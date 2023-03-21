package com.kb.common.exception;

public class AllSearchApiException extends RuntimeException {

    public AllSearchApiException(String message) {
        super(message);
    }

    public AllSearchApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
