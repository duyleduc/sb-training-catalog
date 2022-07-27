package dinhgt.springboot.sbtrainingcatalogs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.services.ICatalogService;

@RestController
@RequestMapping("/api/v1/protected/catalog")
public class CatalogController {

	
	@Autowired
	private ICatalogService catalogService;
	
	
	
	@PostMapping("/")
	public CatalogDTO createCatalog(@RequestBody CatalogDTO catalog) {
		
		return catalogService.create(catalog);
		
	}
	
	@GetMapping("/{id}")
	public CatalogDTO getCatalogByID(@PathVariable String id) {
		return catalogService.getCatalog(id);
	}
	
	@GetMapping("")
	public List<CatalogDTO>getAllCatalog() {
		return catalogService.getAllCatalog();
	}
	
	@PutMapping("/{id}")
	public CatalogDTO updateCatalog( @RequestBody CatalogDTO catalogDTO, @PathVariable int id) {
		
		return catalogService.updateCatalog(catalogDTO, id);
	}
}
