package com.kb.common.domain.popular;

import com.kb.common.exception.InvalidParameterException;

public class PopularSize {

    private static final int MAX_POPULAR_SIZE = 10;

    private final int size;

    private PopularSize(int size) {
        this.size = size;
    }

    public static PopularSize of(int size) {
        if (valid(size)) {
            return new PopularSize(size);
        }
        throw new InvalidParameterException("인기검색어 목록은 1~ 10개까지 검색 가능합니다.");
    }

    private static boolean valid(int size) {
        return 1 <= size && size <= MAX_POPULAR_SIZE;
    }

    public long forRedisRange() {
        return this.size - 1;
    }
}
