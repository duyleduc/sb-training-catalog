package com.training.sbtrainingcatalog.repositories;

import com.training.sbtrainingcatalog.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog,Long> {

    @Query(value = "SELECT * FROM catalog c WHERE c.id = :id",nativeQuery = true)
    Catalog findCatalogById(@Param("id") Long id);

    Catalog findByCatalogID(String catalogId);

    @Query(value = "SELECT id FROM catalog",nativeQuery = true)
    List<Long> findAllCatalogId();


}
