package com.kb.common.dto;

import static com.kb.common.exception.ExceptionStrings.INVALID_PAGE;
import static com.kb.common.exception.ExceptionStrings.INVALID_QUERY;
import static com.kb.common.exception.ExceptionStrings.INVALID_SIZE;
import static com.kb.common.exception.ExceptionStrings.INVALID_SORT;

import java.security.InvalidParameterException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class SearchRequest {

    private static final String SORT_ACCURACY = "accuracy";
    private static final String SORT_RECENCY = "recency";
    private static final int RANGE_PAGE_MIN = 1;
    private static final int RANGE_PAGE_MAX = 50;
    private static final int RANGE_SIZE_MIN = 1;
    private static final int RANGE_SIZE_MAX = 50;

    private String query;

    private String sort;

    private Integer page;

    private Integer size;

    public static SearchRequest of(String query, String sort, Integer page, Integer size) {
        validate(query, sort, page, size);

        return SearchRequest.builder()
            .query(query)
            .sort(sort)
            .page(page)
            .size(size)
            .build();
    }

    private static void validate(String query, String sort, Integer page, Integer size) {
        if (query == null || query.isEmpty()) {
            throw new InvalidParameterException(INVALID_QUERY);
        }

        if (!sort.isEmpty() && !sort.equals(SORT_ACCURACY) && !sort.equals(SORT_RECENCY)) {
            throw new InvalidParameterException(INVALID_SORT);
        }

        if (RANGE_PAGE_MIN > page || page > RANGE_PAGE_MAX) {
            throw new InvalidParameterException(INVALID_PAGE);
        }

        if (RANGE_SIZE_MIN > size || size > RANGE_SIZE_MAX) {
            throw new InvalidParameterException(INVALID_SIZE);
        }
    }

    public String urlWithKakao(String kakaoUrl) {
        StringBuilder sb = new StringBuilder(kakaoUrl);
        sb.append("?query=")
            .append(this.query);

        if (this.sort != null) {
            sb.append("&sort=")
                .append(this.sort);
        }

        if (this.page != null) {
            sb.append("&page=")
                .append(this.page);
        }

        if (this.size != null) {
            sb.append("&size=")
                .append(this.size);
        }

        return sb.toString();
    }
}
