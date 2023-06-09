package com.kb.controller;

import com.kb.common.dto.popular.PopularRequest;
import com.kb.common.dto.popular.PopularResponse;
import com.kb.service.PopularService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/popular")
@RequiredArgsConstructor
public class PopularRestController {

    private final PopularService popularService;

    @GetMapping
    public ResponseEntity<PopularResponse> get(@RequestBody PopularRequest popularRequest) {
        return ResponseEntity.ok().body(popularService.getTop(popularRequest.toSize()));
    }

}
