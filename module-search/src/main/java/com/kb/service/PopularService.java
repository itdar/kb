package com.kb.service;

import com.kb.common.dto.popular.PopularResponse;
import com.kb.common.dto.popular.QueryCountResponse;
import com.kb.domain.QueryCount;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PopularService {

    private final StorageService storageService;

    public PopularResponse getTop10() {
        List<QueryCount> queryCountTop10 = storageService.getTop10();
        return PopularResponse.of(queryCountTop10.stream()
            .map(queryCount -> new QueryCountResponse(queryCount.getQuery(), queryCount.getCount()))
            .collect(Collectors.toList())
        );
    }
}
