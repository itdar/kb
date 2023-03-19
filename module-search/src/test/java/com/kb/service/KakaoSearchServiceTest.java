package com.kb.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.kb.common.dto.SearchRequest;
import com.kb.common.dto.SearchResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoSearchServiceTest {

    @Autowired
    private KakaoSearchService searchService;

    private final String QUERY_STRING = "블로그";

    @Test
    void kakaoBlogSearchWithAllParamTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .sort("recency")
            .page(1)
            .size(10)
            .build();

        SearchResponse searchResponse = searchService.search(searchRequest);

        assertThat(searchResponse.getMeta().getIsEnd()).isFalse();
    }

    @Test
    void kakaoBlogSearchWithSortTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .sort("accuracy")
            .build();

        SearchResponse searchResponse = searchService.search(searchRequest);

        assertThat(searchResponse.getMeta().getIsEnd()).isFalse();
    }

    @Test
    void kakaoBlogSearchWithPageTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .page(1)
            .build();

        SearchResponse searchResponse = searchService.search(searchRequest);

        assertThat(searchResponse.getMeta().getIsEnd()).isFalse();
    }

    @Test
    void kakaoBlogSearchWithSizeTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .size(10)
            .build();

        SearchResponse searchResponse = searchService.search(searchRequest);

        assertThat(searchResponse.getMeta().getIsEnd()).isFalse();
    }

}
