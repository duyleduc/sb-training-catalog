package dinhgt.springboot.sbtrainingcatalogs.validate.item;

import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;
import dinhgt.springboot.sbtrainingcatalogs.exception.item.ItemCreateException;

public class ItemCreateValidate {
	
	public static void validate(ItemDTO item) {
		if(item.getItemID().isEmpty()) throw new ItemCreateException("Item id cannot be empty!");
		if(item.getItemName().isEmpty()) throw new ItemCreateException("Item name cannot be empty!");
	}
}
