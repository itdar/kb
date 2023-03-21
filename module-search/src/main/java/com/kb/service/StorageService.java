package com.kb.service;

import com.kb.common.domain.popular.PopularSize;
import com.kb.common.domain.popular.QueryCounts;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface StorageService {

    @Transactional
    void saveQuery(String query);

    QueryCounts getTop(PopularSize popularSize);

    void clean();

}
