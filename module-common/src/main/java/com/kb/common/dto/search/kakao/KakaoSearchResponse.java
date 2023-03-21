package com.kb.common.dto.search.kakao;

import java.util.List;
import lombok.Data;

@Data
public final class KakaoSearchResponse {

    private Meta meta;

    private List<Document> documents;

}
