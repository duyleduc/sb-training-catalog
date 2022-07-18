package dinhgt.springboot.sbtrainingcatalogs.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;
import dinhgt.springboot.sbtrainingcatalogs.exception.item.ItemCreateException;
import dinhgt.springboot.sbtrainingcatalogs.mappers.ItemModelMapper;
import dinhgt.springboot.sbtrainingcatalogs.model.Item;
import dinhgt.springboot.sbtrainingcatalogs.repositories.ItemRepository;
import dinhgt.springboot.sbtrainingcatalogs.services.ICatalogService;
import dinhgt.springboot.sbtrainingcatalogs.services.IItemService;
import dinhgt.springboot.sbtrainingcatalogs.validate.item.ItemCreateValidate;

@Service
public class ItemService implements IItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemModelMapper itemModelMapper;


	@Autowired
	private ICatalogService catalogService;

	@Override
	public ItemDTO create(ItemDTO item) {
		ItemCreateValidate.validate(item);
		item.setCreatedDate(LocalDateTime.now());

		boolean isExits = itemRepository.existsById(item.getItemID());
		if (isExits)
			throw new ItemCreateException("Duplicate item id");

		CatalogDTO catalogDTO = catalogService.getById(item.getCatalog().getCatalogId());

		item.setCatalog(catalogDTO);

		Item itemDAO = itemRepository.save(itemModelMapper.itemDAO(item));

		return itemModelMapper.itemDTO(itemDAO);
	}

}
