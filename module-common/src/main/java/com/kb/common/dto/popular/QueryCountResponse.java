package com.kb.common.dto.popular;

import lombok.Data;

@Data
public class QueryCountResponse {

    private final String query;

    private final Long count;

    public QueryCountResponse(String query, Long count) {
        this.query = query;
        this.count = count;
    }

}
