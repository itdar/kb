package com.kb.service;

import com.kb.common.domain.QueryCount;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class InMemoryStorageService implements StorageService {

    private static final String REDIS_QUERY_COUNT = "REDIS_QUERY_COUNT";

    private final RedisTemplate<String, Object> redisTemplate;

    @Transactional
    @Override
    public void saveQuery(String query) {
        redisTemplate.opsForZSet().incrementScore(REDIS_QUERY_COUNT, query, 1);
    }

    @Override
    public List<QueryCount> getTop10() {
        return redisTemplate.opsForZSet()
            .reverseRangeWithScores(REDIS_QUERY_COUNT, 0, 9).stream()
            .map(stringTypedTuple -> new QueryCount((String) stringTypedTuple.getValue(), Objects.requireNonNull(stringTypedTuple.getScore()).longValue()))
            .collect(Collectors.toList());
    }

}
