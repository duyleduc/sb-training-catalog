package dinhgt.springboot.sbtrainingcatalogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.services.ICatalogService;

@RestController
@RequestMapping("/api/v1/public")
public class CatalogController {

	
	@Autowired
	private ICatalogService catalogService;
	
	
	
	@PostMapping("/createCatalog")
	public CatalogDTO createCatalog(@RequestBody CatalogDTO catalog) {
		
		return catalogService.create(catalog);
		
	}
	
}
