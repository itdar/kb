package com.kb.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.kb.common.domain.popular.PopularSize;
import com.kb.common.dto.popular.QueryCountResponse;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StorageServiceTest {

    @Autowired
    private RedisStorageService storageService;

    private final String TEST_QUERY = "testQuery";
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @BeforeEach
    void setUp() {
        storageService.clean();
    }

    @Test
    @DisplayName("동시 검색 시 카운트 정상 테스트")
    void concurrentSaveQueryTest() throws InterruptedException {
        final int count = 300;

        // when
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; ++i) {
            executorService.execute(() -> {
                storageService.saveQuery(TEST_QUERY);
                latch.countDown();
            });
        }
        latch.await();

        // then
        QueryCountResponse queryCountResponse = storageService.getTop(PopularSize.of(1)).toQueryCountResponses()
            .stream().findFirst()
            .get();
        assertThat(queryCountResponse.getCount()).isEqualTo(count);
    }

}
