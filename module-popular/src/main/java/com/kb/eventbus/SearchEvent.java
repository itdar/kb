package com.kb.eventbus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SearchEvent {
    private String query;

    public SearchEvent(String query) {
        this.query = query;
    }

}
