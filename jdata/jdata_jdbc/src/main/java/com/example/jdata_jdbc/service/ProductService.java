package com.example.jdata_jdbc.service;

import com.example.jdata_jdbc.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<String> getProduct(String name) {
        return productRepository.getProduct(name);
    }
}
