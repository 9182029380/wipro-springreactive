package com.example.Products.controller;

import com.example.Products.dto.Productdto;
import com.example.Products.model.Product;
import com.example.Products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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
    @GetMapping
    public Flux<Productdto> getProducts(){
        System.out.println("Products data is displayed ................................................................");
        return service.getProducts();
    }
    @GetMapping("/{id}")
    public Mono<Productdto> getProductById(@PathVariable int id){
        System.out.println("Product find by id ................................................................");
        return service.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable int id){
        System.out.println("Product deleted................................................................");
        return service.deleteProduct(id);
    }
    @PutMapping("/{id}")
    public Mono<Productdto> updateProduct(@RequestBody Mono<Productdto> productDtoMono,@PathVariable int id){
        System.out.println("Product updated................................................................");
        return service.updateProduct(productDtoMono,id);
    }
    @GetMapping("/search/{name}")
    public Flux<Productdto> searchProduct(@PathVariable String name){
        System.out.println("Product search................................................................");
        return service.searchProduct(name);
    }
    @GetMapping("/product-range")
    public Flux<Productdto> searchProductByPricerange(@RequestParam("min")double min, @RequestParam("max")double max){
        System.out.println("Product search by price................................................................");
        return service.getProductinrange(min,max);
    }


}
