package com.kb.service.searcher;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;

public interface Searcher {

    SearchResponse search(SearchRequest searchRequest);

}
