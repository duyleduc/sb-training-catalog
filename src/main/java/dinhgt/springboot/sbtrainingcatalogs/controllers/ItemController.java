package dinhgt.springboot.sbtrainingcatalogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;
import dinhgt.springboot.sbtrainingcatalogs.services.IItemService;

@RestController
@RequestMapping("/api/v1/protected/catalog/item")
public class ItemController {

	@Autowired
	private IItemService itemService;

	@PostMapping("")
	public ItemDTO createItem(@RequestBody ItemDTO item) {
		return itemService.create(item);
	}

	@PutMapping("/{id}")
	public ItemDTO updateItem(@RequestBody ItemDTO item, @PathVariable int id) {

		return itemService.update(item, id);
	}

	@GetMapping("/{id}")
	public ItemDTO getItemByID(@PathVariable String id) {
		return itemService.getItemByID(id);
	}

	@PutMapping("/itemID/{id}")
	public void updateItem(@RequestBody ItemDTO item, @PathVariable String id) {

		itemService.updateByItemID(item);
	}
}
