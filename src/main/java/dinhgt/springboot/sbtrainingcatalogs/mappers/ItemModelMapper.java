package dinhgt.springboot.sbtrainingcatalogs.mappers;

import org.mapstruct.Mapper;

import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;
import dinhgt.springboot.sbtrainingcatalogs.model.Item;

@Mapper(componentModel = "spring")
public interface ItemModelMapper {

	ItemDTO itemDTO(Item item);

	Item itemDAO(ItemDTO item);
	
}
