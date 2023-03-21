package com.kb.service;

import com.kb.common.domain.popular.PopularSize;
import com.kb.common.domain.popular.QueryCounts;
import com.kb.common.dto.popular.PopularResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PopularService {

    private final StorageService storageService;

    public PopularResponse getTop(PopularSize popularSize) {
        QueryCounts queryCounts = storageService.getTop(popularSize);
        return PopularResponse.of(queryCounts.toQueryCountResponses());
    }
}
