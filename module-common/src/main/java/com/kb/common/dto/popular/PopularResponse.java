package com.kb.common.dto.popular;

import java.util.List;
import lombok.Data;

@Data
public class PopularResponse {

    private final List<PopularQueryCount> popularQueryCounts;

}
