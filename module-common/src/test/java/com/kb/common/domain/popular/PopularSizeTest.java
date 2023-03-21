package com.kb.common.domain.popular;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.kb.common.exception.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PopularSizeTest {

    @DisplayName("유효한 인기검색어 사이즈 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void validCreationTest(int size) {
        PopularSize popularSize = PopularSize.of(size);
        assertThat(popularSize).isNotNull();
    }

    @DisplayName("유효하지 않은 인기검색어 사이즈 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void createTest(int size) {
        assertThatThrownBy(
            () -> PopularSize.of(size)
        ).isInstanceOf(InvalidParameterException.class);
    }

}
