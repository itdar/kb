package com.kb.service;

import com.kb.domain.QueryCount;
import java.util.List;

public interface StorageService {

    void saveQuery(String query);

    List<QueryCount> getTop10();

}
