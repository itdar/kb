package com.kb.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class QueryCount {

    private String query;
    private Long count;

    public QueryCount(String query, Long count) {
        this.query = query;
        this.count = count;
    }

}
