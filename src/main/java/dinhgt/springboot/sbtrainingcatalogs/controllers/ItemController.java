package dinhgt.springboot.sbtrainingcatalogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhgt.springboot.sbtrainingcatalogs.dtos.ItemDTO;
import dinhgt.springboot.sbtrainingcatalogs.services.IItemService;

@RestController
@RequestMapping("/api/v1/public")
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	@PostMapping("/createItem")
	public ItemDTO createItem(@RequestBody ItemDTO item) {
		
		return itemService.create(item);
	}
	
}
