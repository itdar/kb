package com.kb.service;

import com.kb.common.domain.popular.PopularSize;
import com.kb.common.domain.popular.QueryCount;
import com.kb.common.domain.popular.QueryCounts;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisStorageService implements StorageService {

    private static final String REDIS_QUERY_COUNT = "REDIS_QUERY_COUNT";

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void saveQuery(String query) {
        redisTemplate.opsForZSet().incrementScore(REDIS_QUERY_COUNT, query, 1);
    }

    @Override
    public QueryCounts getTop(PopularSize popularSize) {
        return QueryCounts.of(redisTemplate.opsForZSet()
            .reverseRangeWithScores(REDIS_QUERY_COUNT, 0, popularSize.forRedisRange()).stream()
            .map(stringTypedTuple -> new QueryCount((String) stringTypedTuple.getValue(), Objects.requireNonNull(stringTypedTuple.getScore()).longValue()))
            .collect(Collectors.toList()));
    }

    @Override
    public void clean() {
        redisTemplate.opsForZSet().removeRange(REDIS_QUERY_COUNT, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
