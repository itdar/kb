package com.kb.common.dto.popular;

import java.util.List;
import lombok.Data;

@Data
public class PopularResponse {

    private final List<QueryCountResponse> queryCountResponses;

    public static PopularResponse of(List<QueryCountResponse> queryCountResponses) {
        return new PopularResponse(queryCountResponses);
    }

}
