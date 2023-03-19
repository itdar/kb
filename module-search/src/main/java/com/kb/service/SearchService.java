package com.kb.service;

import com.kb.common.dto.SearchRequest;
import com.kb.common.dto.SearchResponse;

public interface SearchService {

    SearchResponse search(SearchRequest searchRequest);

}
