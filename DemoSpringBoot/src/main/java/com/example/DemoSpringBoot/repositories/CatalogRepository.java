package com.example.DemoSpringBoot.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DemoSpringBoot.entities.Catalogs;

@Repository
public interface CatalogRepository extends JpaRepository<Catalogs, BigInteger> {
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Catalogs c WHERE c.catalogID = :catalogID")
    boolean IsCataLog(@Param("catalogID") String catalogID);

    Optional<Catalogs> findByCatalogID(String catalogID);

}
