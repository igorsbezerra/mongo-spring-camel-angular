package dev.igor.backend.service.impl;

import dev.igor.backend.dto.ProductRequest;
import dev.igor.backend.model.Product;
import dev.igor.backend.repository.ProductRepository;
import dev.igor.backend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        return productRepository.save(Product.of(request));
    }
}
