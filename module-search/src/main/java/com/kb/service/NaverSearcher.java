package com.kb.service;

import static com.kb.common.exception.ExceptionStrings.NAVER_API_EXCEPTION;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;
import com.kb.common.dto.search.naver.NaverSearchResponse;
import com.kb.common.exception.InvalidParameterException;
import com.kb.common.exception.NaverSearchApiException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class NaverSearcher implements Searcher {

    @Value("${naver.url}")
    private String naverUrl;

    @Value("${naver.clientId}")
    private String naverClientId;

    @Value("${naver.clientSecret}")
    private String naverClientSecret;

    private final RestTemplate restTemplate;

    @Override
    public SearchResponse search(SearchRequest searchRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);

        HttpEntity<?> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<NaverSearchResponse> response;
        try {
            response = restTemplate.exchange(
                searchRequest.urlWithNaver(naverUrl),
                HttpMethod.GET, httpEntity, NaverSearchResponse.class);
        } catch (InvalidParameterException e) {
            throw e;
        } catch (Exception e) {
            throw new NaverSearchApiException(NAVER_API_EXCEPTION);
        }

        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            throw new NaverSearchApiException(NAVER_API_EXCEPTION);
        }

        return SearchResponse.of(Objects.requireNonNull(response.getBody()));
    }

}
