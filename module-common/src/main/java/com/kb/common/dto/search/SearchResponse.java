package com.kb.common.dto.search;

import java.util.List;
import lombok.Data;

@Data
public final class SearchResponse {

    private Meta meta;

    private List<Documents> documents;

}
