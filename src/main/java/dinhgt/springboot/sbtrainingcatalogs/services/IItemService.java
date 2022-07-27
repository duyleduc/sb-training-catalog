package dinhgt.springboot.sbtrainingcatalogs.services;

import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;

public interface IItemService {

	ItemDTO create(ItemDTO item);
	
	ItemDTO update(ItemDTO item, int id);
	
	ItemDTO getItemByID(String id);
	
	void updateByItemID(ItemDTO item);
	
}
