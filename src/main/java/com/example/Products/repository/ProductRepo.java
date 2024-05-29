package com.example.Products.repository;

import com.example.Products.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepo extends ReactiveMongoRepository<Product, Integer> {
}
