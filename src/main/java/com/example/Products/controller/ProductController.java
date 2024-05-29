package com.example.Products.controller;

import com.example.Products.dto.Productdto;
import com.example.Products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public Mono<Productdto> saveProduct(@RequestBody Mono<Productdto> productDtoMono){
        System.out.println("Product saved................................................................");
        return service.saveProduct(productDtoMono);
    }

}
