package com.kb.service;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;
import com.kb.common.enums.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchServiceFactory searchServiceFactory;

    public SearchResponse search(SearchRequest searchRequest) {
        for (SearchType searchType : SearchType.values()) {
            Searcher searcher = searchServiceFactory.get(searchType);
            SearchResponse searchResponse;
            try {
                searchResponse = searcher.search(searchRequest);
            } catch (Exception e) {
                continue;
            }
            return searchResponse;
        }
        throw new RuntimeException("모든 검색기 실패");
    }
}
