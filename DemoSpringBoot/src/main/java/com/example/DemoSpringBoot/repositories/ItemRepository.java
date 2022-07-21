package com.example.DemoSpringBoot.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DemoSpringBoot.entities.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items,BigInteger>{
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Items c WHERE c.itemID = :itemID")
    boolean IsCataLog(@Param("itemID") String itemID);
    Optional<Items> findByItemID(String itemID);
}
