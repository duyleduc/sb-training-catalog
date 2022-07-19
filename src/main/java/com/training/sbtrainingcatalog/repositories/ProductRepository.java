package com.training.sbtrainingcatalog.repositories;

import com.training.sbtrainingcatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findByItemID(String itemID);
}
