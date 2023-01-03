package com.ecommerce.elasticsearch.Domain;

import lombok.Data;

@Data
public class Product {
    public int id;

    public Double _score;
    public String title;
    public String type;
    public String description;
    public String filename;
    public int height;
    public int width;
    public double price;
    public int rating;
}
