package com.kb.service;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;

public interface SearchService {

    SearchResponse search(SearchRequest searchRequest);

}
