package dinhgt.springboot.sbtrainingcatalogs.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhgt.springboot.sbtrainingcatalogs.model.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

	boolean existsByCatalogIdAndIsActivated(String id, boolean isActivated);
	
	boolean existsByCatalogNameAndIsActivated(String name, boolean isActivated);
	
	Catalog getReferenceByCatalogIdAndIsActivated(String id, boolean isActivated);
	
	Optional<Catalog> findByIdAndIsActivated(int id, boolean isActivated);
	
	List<Catalog> findAllByIsActivated(boolean isActivated);
}
