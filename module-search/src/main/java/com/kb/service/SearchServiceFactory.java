package com.kb.service;

import com.kb.common.enums.SearchType;
import com.kb.service.searcher.KakaoSearcher;
import com.kb.service.searcher.NaverSearcher;
import com.kb.service.searcher.Searcher;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

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

    public void put(SearchType searchType, Searcher searcher) {
        this.searchServiceMap.put(searchType, searcher);
    }
}
