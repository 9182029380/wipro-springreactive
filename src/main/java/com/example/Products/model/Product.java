package com.example.Products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private int id;
    private String name;
    private double price;
    private String description;
    private String manufacturer;
    private String category;
    private String image;
    private int quantity;
    private String status;
    private int discount;
    private String color;
    private String size;
}
