package com.kb.common.dto;

import java.util.List;
import lombok.Data;

@Data
public final class SearchResponse {

    private Meta meta;

    private List<Documents> documents;

}
