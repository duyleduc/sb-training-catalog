package dinhgt.springboot.sbtrainingcatalogs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhgt.springboot.sbtrainingcatalogs.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	boolean existsByItemID(String id);

	Item getReferenceByItemID(String id);

	boolean existsByItemIDAndIsActivated(String id, boolean isActivated);

	boolean existsByItemNameAndIsActivated(String name, boolean isActivated);
	
	Item findByItemID(String id);

}
