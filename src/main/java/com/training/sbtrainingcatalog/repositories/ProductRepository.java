package com.training.sbtrainingcatalog.repositories;

import com.training.sbtrainingcatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByItemID(String itemID);

    @Query(value = "SELECT * FROM product p WHERE p.id = :id",nativeQuery = true)
    Product findProductById(@Param("id") Long id);
}
