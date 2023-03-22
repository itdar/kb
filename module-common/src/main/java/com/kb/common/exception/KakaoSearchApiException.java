package com.kb.common.exception;

public class KakaoSearchApiException extends RuntimeException {

    public KakaoSearchApiException(String message) {
        super(message);
    }

    public KakaoSearchApiException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
