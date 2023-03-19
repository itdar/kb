package com.kb.exception;

import com.kb.common.exception.KakaoSearchApiException;
import com.kb.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    public final SearchService searchService;

    @ExceptionHandler(KakaoSearchApiException.class)
    public ResponseEntity handleKakaoSearchApiException(KakaoSearchApiException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}