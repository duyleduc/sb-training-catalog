package com.training.sbtrainingcatalog.repositories;

import com.training.sbtrainingcatalog.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog,String> {
    Catalog findByCatalogID(String catalogId);

    @Query(value = "SELECT catalog_id FROM catalog",nativeQuery = true)
    List<String> findAllCatalogID();
}
