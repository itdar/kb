package com.kb.service;

import com.kb.common.enums.SearchType;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SearchServiceFactory {

    private final KakaoSearcher kakaoSearcher;
    private final NaverSearcher naverSearcher;

    private Map<SearchType, Searcher> searchServiceMap = new LinkedHashMap<>();

    public SearchServiceFactory(KakaoSearcher kakaoSearcher, NaverSearcher naverSearcher) {
        this.kakaoSearcher = kakaoSearcher;
        this.naverSearcher = naverSearcher;
        searchServiceMap.put(SearchType.KAKAO, this.kakaoSearcher);
        searchServiceMap.put(SearchType.NAVER, this.naverSearcher);
    }

    public Searcher get(SearchType searchType) {
        return searchServiceMap.get(searchType);
    }

}
