package com.kb.common.dto.search.naver;

import java.util.List;
import lombok.Data;

@Data
public class NaverSearchResponse {

    private String lastBuildDate;
    private Integer total;
    private Integer start;
    private Integer display;
    private List<Item> items;

}
