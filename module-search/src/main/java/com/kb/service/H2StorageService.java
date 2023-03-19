package com.kb.service;

import com.kb.common.dto.popular.PopularResponse;
import com.kb.domain.QueryCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class H2StorageService implements StorageService {

    private final QueryCountRepository queryCountRepository;

    @Transactional
    @Override
    public void saveQuery(String query) {

    }

    @Override
    public PopularResponse getTop10() {
        return null;
    }

}
