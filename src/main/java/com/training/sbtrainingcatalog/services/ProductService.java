package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(String itemID);
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    String removeProduct(String itemID);
}
