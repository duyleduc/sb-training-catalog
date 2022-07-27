package dinhgt.springboot.sbtrainingcatalogs.validate.item;

import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;
import dinhgt.springboot.sbtrainingcatalogs.exception.item.ItemUpdateException;

public class ItemCreateValidate {
	
	public static void validate(ItemDTO item) {
		try {
			if(item.getItemID().isEmpty()) throw new ItemUpdateException("Item id cannot be empty!");
		} catch (NullPointerException e) {
			throw new ItemUpdateException("Item id cannot be empty!");
		}
	
		try {
			if(item.getItemName().isEmpty()) throw new ItemUpdateException("Item name cannot be empty!");
		} catch (NullPointerException e) {
			throw new ItemUpdateException("Item name cannot be empty!");
		}
	}
}
