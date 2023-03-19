package com.kb.controller;

import com.kb.common.dto.popular.PopularResponse;
import com.kb.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search/popular")
@RequiredArgsConstructor
public class PopularSearchRestController {

    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<PopularResponse> get() {
        return ResponseEntity.ok().body(storageService.getTop10());
    }

}
