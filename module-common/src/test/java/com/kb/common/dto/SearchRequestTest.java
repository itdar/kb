package com.kb.common.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.exception.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchRequestTest {

    private final String QUERY = "테스트검색어";

    @DisplayName("정상 생성")
    @Test
    void validationTest1() {
        SearchRequest searchRequest = SearchRequest.of(QUERY, "accuracy", 1, 1);

        assertThat(searchRequest.getPage()).isOne();
    }

    @DisplayName("검색어는 필수 값인데 없으면 예외")
    @Test
    void validationTest2() {
        assertThatThrownBy(
            () -> SearchRequest.of("", "", 1, 1)
        ).isInstanceOf(InvalidParameterException.class);
    }

    @DisplayName("page, size 는 1~ 50 이내 범위인데 벗어나면 예외")
    @Test
    void validationTest3() {
        assertThatThrownBy(
            () -> SearchRequest.of(QUERY, "", 0, 1)
        ).isInstanceOf(InvalidParameterException.class);

        assertThatThrownBy(
            () -> SearchRequest.of(QUERY, "", 1, 0)
        ).isInstanceOf(InvalidParameterException.class);

        assertThatThrownBy(
            () -> SearchRequest.of(QUERY, "", 51, 50)
        ).isInstanceOf(InvalidParameterException.class);

        assertThatThrownBy(
            () -> SearchRequest.of(QUERY, "", 50, 51)
        ).isInstanceOf(InvalidParameterException.class);
    }

}
