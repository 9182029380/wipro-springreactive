package com.example.Products.repository;

import com.example.Products.dto.Productdto;
import com.example.Products.model.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepo extends ReactiveMongoRepository<Product, Integer> {
    Flux<Productdto> findByPriceBetween(Range<Double> priceRange);

    Flux<Productdto> findByName(String name);
}

