package dinhgt.springboot.sbtrainingcatalogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhgt.springboot.sbtrainingcatalogs.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{

}
