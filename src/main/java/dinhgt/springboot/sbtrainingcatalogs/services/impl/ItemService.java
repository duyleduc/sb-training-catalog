package dinhgt.springboot.sbtrainingcatalogs.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;
import dinhgt.springboot.sbtrainingcatalogs.exception.catalog.CatalogCreateException;
import dinhgt.springboot.sbtrainingcatalogs.exception.item.ItemCreateException;
import dinhgt.springboot.sbtrainingcatalogs.exception.item.ItemUpdateException;
import dinhgt.springboot.sbtrainingcatalogs.mappers.CatalogModelMapper;
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
	private CatalogModelMapper catalogModelMapper;

	@Autowired
	private ICatalogService catalogService;

	@Override
	public ItemDTO create(ItemDTO item) {
		ItemCreateValidate.validate(item);

		boolean isExits = itemRepository.existsByItemIDAndIsActivated(item.getItemID(), true);
		if (isExits)
			throw new ItemCreateException("Duplicate item id");

		isExits = itemRepository.existsByItemNameAndIsActivated(item.getItemID(), true);
		if (isExits)
			throw new ItemCreateException("Duplicate name id");

		CatalogDTO catalogDTO = catalogService.getById(item.getCatalog().getId());

		item.setCreatedDate(LocalDateTime.now());
		item.setId(0);
		item.setActivated(true);
		item.setCatalog(catalogDTO);
		Item result = itemModelMapper.itemDAO(item);
		Item itemDAO = itemRepository.save(result);

		return itemModelMapper.itemDTO(itemDAO);
	}

	@Override
	public ItemDTO update(ItemDTO itemDTO, int id) {
		System.out.println(itemDTO.getQuantity());
		if (Integer.compare(itemDTO.getId(), id) != 0)
			throw new ItemUpdateException("ID not match!");

		boolean checkExits = itemRepository.existsById(id);
		if (!checkExits)
			throw new ItemUpdateException("Item ID not exits!");
		checkExits = itemRepository.existsByItemIDAndIsActivated(itemDTO.getItemID(), true);
		if (checkExits)
			throw new CatalogCreateException("Duplicate id item!");
		checkExits = itemRepository.existsByItemNameAndIsActivated(itemDTO.getItemName(), true);
		if (checkExits)
			throw new CatalogCreateException("Duplicate name item!");

		CatalogDTO catalogDTO = catalogService.getById(itemDTO.getCatalog().getId());
		itemDTO.setCatalog(catalogDTO);
		Item item = itemRepository.getReferenceById(id);

		customMapping(itemDTO, item);

		return itemModelMapper.itemDTO(itemRepository.save(item));
	}

	public void customMapping(ItemDTO itemDTO, Item item) {
		if (itemDTO.getItemID() != null)
			item.setItemID(itemDTO.getItemID());
		if (itemDTO.getCatalog() != null)
			item.setCatalog(catalogModelMapper.catalogDAO(itemDTO.getCatalog()));
		if (itemDTO.getItemName() != null)
			item.setItemName(itemDTO.getItemName());
		if (itemDTO.getDescription() != null)
			item.setDescription(itemDTO.getDescription());
		if (itemDTO.getQuantity() != -1)
			item.setQuantity(itemDTO.getQuantity());
		item.setUpdatedDate(LocalDateTime.now());
	}

	@Override
	public ItemDTO getItemByID(String id) {

		Item itemDAO = itemRepository.getReferenceByItemID(id);

		return itemModelMapper.itemDTO(itemDAO);
	}

	@Override
	public void updateByItemID(ItemDTO item) {
		Item itemDAO = itemRepository.findByItemID(item.getItemID());

		if (itemDAO == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, item.getItemID() + " not found");
		itemDAO.setQuantity(itemDAO.getQuantity() - item.getQuantity());
		itemRepository.save(itemDAO);

	}

}
