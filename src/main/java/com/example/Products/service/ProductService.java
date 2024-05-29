package com.example.Products.service;

import com.example.Products.dto.Productdto;
import com.example.Products.model.Product;
import com.example.Products.repository.ProductRepo;
import com.example.Products.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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

    public Flux<Productdto> getProducts() {
        return repo.findAll().map(AppUtils::entityToDto);
    }

    public Mono<Productdto> getProductById(int id) {
        return repo.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteProduct(int id) {
        return repo.deleteById(id);
    }

    public Mono<Productdto> updateProduct( Mono<Productdto> productDtoMono,int id) {
        return repo.findById(id)
                .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                        .flatMap(repo::save)
                        .map(AppUtils::entityToDto);
    }

    public Flux<Productdto> searchProduct(String name) {
        return repo.findByName(name);
    }

    public Flux<Productdto> getProductinrange(double min, double max) {
        return repo.findByPriceBetween(Range.closed(min,max));
    }
}
