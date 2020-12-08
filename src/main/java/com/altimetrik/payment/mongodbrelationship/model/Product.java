package com.altimetrik.payment.mongodbrelationship.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String name;
    private int  quality;
    private int price;
}
