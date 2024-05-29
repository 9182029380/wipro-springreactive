package com.example.Products.service;

import com.example.Products.dto.Productdto;
import com.example.Products.repository.ProductRepo;
import com.example.Products.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;
    public Mono<Productdto> saveProduct(Mono<Productdto> productDtoMono) {
        System.out.println("Inside saveProduct");

        return productDtoMono.map(AppUtils::dtoToEntity)
                .flatMap(repo::insert)
                .map(AppUtils::entityToDto);
    }
}
