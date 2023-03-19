package com.kb.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QueryCountRepositoryTest {

    private final String 검색어 = "블로그";

    @Autowired
    private QueryCountRepository queryCountRepository;

    @Test
    void findNSaveTest() {
        queryCountRepository.save(QueryCount.of(검색어, 1));
        QueryCount foundQueryCount = queryCountRepository.findByQuery(검색어);
        QueryCount savedQueryCount = queryCountRepository.save(
            QueryCount.of(검색어, foundQueryCount.getCount() + 1)
        );

        assertThat(savedQueryCount).isNotNull();
        assertThat(savedQueryCount.getQuery()).isEqualTo(검색어);
        assertThat(savedQueryCount.getCount()).isEqualTo(2);
        assertThat(savedQueryCount.getCreatedTime()).isBefore(LocalDateTime.now());
        assertThat(savedQueryCount.getModifiedTime()).isBefore(LocalDateTime.now());
    }

}
