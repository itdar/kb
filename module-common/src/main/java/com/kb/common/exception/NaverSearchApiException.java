package com.kb.common.exception;

public class NaverSearchApiException extends RuntimeException {

    public NaverSearchApiException(String message) {
        super(message);
    }

    public NaverSearchApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
