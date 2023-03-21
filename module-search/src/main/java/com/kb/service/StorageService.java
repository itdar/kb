package com.kb.service;

import com.kb.common.domain.QueryCount;
import java.util.List;

public interface StorageService {

    void saveQuery(String query);

    List<QueryCount> getTop10();

}
