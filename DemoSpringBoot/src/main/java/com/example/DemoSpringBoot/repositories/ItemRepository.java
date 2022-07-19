package com.example.DemoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DemoSpringBoot.entities.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items,String>{
    
}
