package com.kb.common.dto.search;

import com.kb.common.dto.search.kakao.KakaoSearchResponse;
import com.kb.common.dto.search.naver.NaverSearchResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class SearchResponse {

    private final Info info;
    private final List<Content> contents;

    public static SearchResponse of(KakaoSearchResponse kakaoSearchResponse) {
        return new SearchResponse(
            new Info(
                kakaoSearchResponse.getMeta().getTotalCount(),
                kakaoSearchResponse.getMeta().getPageableCount(),
                kakaoSearchResponse.getMeta().getIsEnd()),
            kakaoSearchResponse.getDocuments().stream()
                .map(Content::of)
                .collect(Collectors.toList())
        );
    }

    public static SearchResponse of(NaverSearchResponse naverSearchResponse) {
        int pageableCount = Math.min(naverSearchResponse.getTotal() / naverSearchResponse.getDisplay(), 1000);
        return new SearchResponse(
            new Info(
                naverSearchResponse.getTotal(),
                pageableCount,
                naverSearchResponse.getTotal() <= pageableCount * naverSearchResponse.getDisplay()),
            naverSearchResponse.getItems().stream()
                .map(Content::of)
                .collect(Collectors.toList())
        );
    }

}
