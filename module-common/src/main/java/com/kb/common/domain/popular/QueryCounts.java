package com.kb.common.domain.popular;

import com.kb.common.dto.popular.QueryCountResponse;
import java.util.List;
import java.util.stream.Collectors;

public class QueryCounts {

    private List<QueryCount> queryCounts;

    private QueryCounts(List<QueryCount> queryCounts) {
        this.queryCounts = queryCounts;
    }

    public static QueryCounts of(List<QueryCount> queryCounts) {
        return new QueryCounts(queryCounts);
    }

    public List<QueryCountResponse> toQueryCountResponses() {
        return queryCounts.stream()
            .map(queryCount -> new QueryCountResponse(queryCount.getQuery(), queryCount.getCount()))
            .collect(Collectors.toList());
    }
}
