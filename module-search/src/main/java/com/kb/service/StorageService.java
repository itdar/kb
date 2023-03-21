package com.kb.service;

import com.kb.common.domain.popular.PopularSize;
import com.kb.common.domain.popular.QueryCounts;

public interface StorageService {

    void saveQuery(String query);

    QueryCounts getTop(PopularSize popularSize);

}
