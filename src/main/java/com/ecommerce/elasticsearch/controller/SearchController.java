package com.ecommerce.elasticsearch.controller;

import com.ecommerce.elasticsearch.Domain.Product;
import com.ecommerce.elasticsearch.Service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping()
    public ResponseEntity<ArrayList<Product>> search(@RequestParam String query) throws IOException {
        ArrayList<Product> search = searchService.search(query);
        return ResponseEntity.ok().body(search);
    }
}
