package com.example.Products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productdto {
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
