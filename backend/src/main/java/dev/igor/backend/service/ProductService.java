package dev.igor.backend.service;

import dev.igor.backend.dto.ProductRequest;
import dev.igor.backend.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product create(ProductRequest product);

}
