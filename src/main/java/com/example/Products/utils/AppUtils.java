package com.example.Products.utils;

import com.example.Products.dto.Productdto;
import com.example.Products.model.Product;
import org.springframework.beans.BeanUtils;

public class AppUtils {

    public static Productdto entityToDto(Product product) {
        Productdto productdto = new Productdto();
        BeanUtils.copyProperties(product, productdto);
        return productdto;
    }
    public static Product dtoToEntity(Productdto productdto) {
        Product product = new Product();
        BeanUtils.copyProperties(productdto, product);
        return product;
    }
}
