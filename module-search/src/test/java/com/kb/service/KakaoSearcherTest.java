package com.kb.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;
import com.kb.common.enums.SearchType;
import com.kb.common.exception.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoSearcherTest {

    @Autowired
    private SearchServiceFactory searchServiceFactory;
    private Searcher searcher;

    private final String QUERY_STRING = "블로그";

    @BeforeEach
    void setUp() {
        this.searcher = searchServiceFactory.get(SearchType.KAKAO);
    }

    @DisplayName("Query 는 필수 값이라서 없으면 예외 발생한다.")
    @Test
    void kakaoBlogSearchWithoutQuery() {
        SearchRequest searchRequest = SearchRequest.builder()
            .sort("recency")
            .page(1)
            .size(10)
            .build();

        assertThatThrownBy(
            () -> searcher.search(searchRequest)
        ).isInstanceOf(InvalidParameterException.class);
    }

    @Test
    void kakaoBlogSearchWithAllParamTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .sort("recency")
            .page(1)
            .size(10)
            .build();

        SearchResponse searchResponse = searcher.search(searchRequest);

        assertThat(searchResponse.getInfo().getIsEnd()).isFalse();
    }

    @Test
    void kakaoBlogSearchWithSortTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .sort("accuracy")
            .build();

        SearchResponse searchResponse = searcher.search(searchRequest);

        assertThat(searchResponse.getInfo().getIsEnd()).isFalse();
    }

    @Test
    void kakaoBlogSearchWithPageTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .page(1)
            .build();

        SearchResponse searchResponse = searcher.search(searchRequest);

        assertThat(searchResponse.getInfo().getIsEnd()).isFalse();
    }

    @Test
    void kakaoBlogSearchWithSizeTest() {
        SearchRequest searchRequest = SearchRequest.builder()
            .query(QUERY_STRING)
            .size(10)
            .build();

        SearchResponse searchResponse = searcher.search(searchRequest);

        assertThat(searchResponse.getInfo().getIsEnd()).isFalse();
    }

}
