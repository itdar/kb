package com.kb.common.dto.search;

import lombok.Data;

@Data
public class Info {

    private final Integer totalCount;
    private final Integer pageableCount;
    private final Boolean isEnd;

}
