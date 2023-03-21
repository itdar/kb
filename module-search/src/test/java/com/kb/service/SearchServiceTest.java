package com.kb.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;
import com.kb.common.enums.SearchType;
import com.kb.common.exception.AllSearchApiException;
import com.kb.common.exception.KakaoSearchApiException;
import com.kb.common.exception.NaverSearchApiException;
import com.kb.service.searcher.KakaoSearcher;
import com.kb.service.searcher.NaverSearcher;
import com.kb.service.searcher.Searcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class SearchServiceTest {

    @MockBean
    private SearchService searchService;

    @Autowired
    private SearchServiceFactory searchServiceFactory;

    private Searcher kakaoSearcher;
    private Searcher naverSearcher;

    @BeforeEach
    void setUp() {
        kakaoSearcher = mock(KakaoSearcher.class);
        naverSearcher = mock(NaverSearcher.class);
    }

    @DisplayName("카카오API 실패 시 네이버API 호출한다.")
    @Test
    void backupServiceTest() {
        when(kakaoSearcher.search(any())).thenThrow(KakaoSearchApiException.class);
        searchServiceFactory.put(SearchType.KAKAO, kakaoSearcher);
        searchService = new SearchService(searchServiceFactory);

        SearchResponse searchResponse = searchService.search(
            SearchRequest.of("testQuery", "accuracy", 1, 10)
        );

        assertThat(searchResponse).isNotNull();
    }

    @DisplayName("카카오API 와 네이버API 모두 실패 시 예외 나온다.")
    @Test
    void allServiceFailTest() {
        when(kakaoSearcher.search(any())).thenThrow(KakaoSearchApiException.class);
        when(naverSearcher.search(any())).thenThrow(NaverSearchApiException.class);
        searchServiceFactory.put(SearchType.KAKAO, kakaoSearcher);
        searchServiceFactory.put(SearchType.NAVER, naverSearcher);
        searchService = new SearchService(searchServiceFactory);

        assertThatThrownBy(
            () -> searchService.search(SearchRequest.of("testQuery", "accuracy", 1, 10))
        ).isInstanceOf(AllSearchApiException.class);
    }

}
