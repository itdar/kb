package com.kb.service;

import static com.kb.common.exception.ExceptionStrings.KAKAO_API_EXCEPTION;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;
import com.kb.common.exception.KakaoSearchApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class KakaoSearchService implements SearchService {

    @Value("${kakao.url}")
    private String kakaoUrl;

    @Value("${kakao.ak}")
    private String kakaoAk;

    private final RestTemplate restTemplate;

    @Override
    public SearchResponse search(SearchRequest searchRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", kakaoAk);

        HttpEntity<?> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<SearchResponse> response;
        try {
            response = restTemplate.exchange(
                searchRequest.urlWithKakao(kakaoUrl),
                HttpMethod.GET, httpEntity, SearchResponse.class);
        } catch (Exception e) {
            throw new KakaoSearchApiException(KAKAO_API_EXCEPTION);
        }

        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            throw new KakaoSearchApiException(KAKAO_API_EXCEPTION);
        }

        return response.getBody();
    }

}
