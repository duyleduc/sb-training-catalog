package dinhgt.springboot.sbtrainingcatalogs.services;

import java.util.List;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;

public interface ICatalogService {
	
	
	
	CatalogDTO create(CatalogDTO catalog);
	
	
	CatalogDTO getById(int id);
	
	
	CatalogDTO getCatalog(String id);
	
	List<CatalogDTO> getAllCatalog();
	
	CatalogDTO updateCatalog(CatalogDTO catalog, int id);
}
