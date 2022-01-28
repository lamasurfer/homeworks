package com.example.jdata_jdbc.controller;

import com.example.jdata_jdbc.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProduct(@RequestParam String name) {
        return productService.getProduct(name);
    }
}
