package com.kb.service;

import com.kb.common.dto.popular.PopularResponse;

public interface StorageService {

    void saveQuery(String query);

    PopularResponse getTop10();

}
