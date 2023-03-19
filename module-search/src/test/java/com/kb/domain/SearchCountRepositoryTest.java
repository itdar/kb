package com.kb.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.kb.common.domain.SearchCount;
import com.kb.common.domain.SearchCountRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchCountRepositoryTest {

    private final String 검색어 = "블로그";

    @Autowired
    private SearchCountRepository searchCountRepository;

    @Test
    void findNSaveTest() {
        searchCountRepository.save(SearchCount.of(검색어, 1));
        SearchCount foundSearchCount = searchCountRepository.findByQuery(검색어);
        SearchCount savedSearchCount = searchCountRepository.save(
            SearchCount.of(검색어, foundSearchCount.getCount() + 1)
        );

        assertThat(savedSearchCount).isNotNull();
        assertThat(savedSearchCount.getQuery()).isEqualTo(검색어);
        assertThat(savedSearchCount.getCount()).isEqualTo(2);
        assertThat(savedSearchCount.getCreatedTime()).isBefore(LocalDateTime.now());
        assertThat(savedSearchCount.getModifiedTime()).isBefore(LocalDateTime.now());
    }

}
