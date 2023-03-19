package com.kb.common.dto.search;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class Meta {

    private Integer totalCount;

    private Integer pageableCount;

    private Boolean isEnd;

}
