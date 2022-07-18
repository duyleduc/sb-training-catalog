package dinhgt.springboot.sbtrainingcatalogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhgt.springboot.sbtrainingcatalogs.model.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, String> {

}
