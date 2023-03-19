package com.kb.common.dto.popular;

import lombok.Data;

@Data
public class PopularQueryCount {

    private final String query;

    private final int count;

}
