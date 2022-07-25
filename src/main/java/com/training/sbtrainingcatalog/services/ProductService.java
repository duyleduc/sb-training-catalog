package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(Long id);

    Product getProductByItemID(String itemID);
    Product saveProduct(Product product);
    Product updateProduct(Product product,Long id);
    Long removeProduct(Long id);
}
