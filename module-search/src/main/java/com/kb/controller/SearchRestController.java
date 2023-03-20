package com.kb.controller;

import com.kb.common.dto.search.SearchRequest;
import com.kb.common.dto.search.SearchResponse;
import com.kb.service.SearchService;
import com.kb.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search")
@RequiredArgsConstructor
public class SearchRestController {

    private final SearchService searchService;
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<SearchResponse> search(
        @RequestParam String query,
        @RequestParam(defaultValue = "accuracy") String sort,
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "10") Integer size) {
        storageService.saveQuery(query);
        return ResponseEntity.ok().body(searchService.search(SearchRequest.of(query, sort, page, size)));
    }

}
