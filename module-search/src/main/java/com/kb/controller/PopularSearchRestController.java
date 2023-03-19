package com.kb.controller;

import com.kb.common.dto.SearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search/popular")
public class PopularSearchRestController {

    @GetMapping
    public ResponseEntity<SearchResponse> get() {
        return null;
    }

}
