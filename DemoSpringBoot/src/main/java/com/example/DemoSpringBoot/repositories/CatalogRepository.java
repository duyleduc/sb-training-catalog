package com.example.DemoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DemoSpringBoot.entities.Catalogs;

@Repository
public interface CatalogRepository extends JpaRepository<Catalogs,String>{
    
}
