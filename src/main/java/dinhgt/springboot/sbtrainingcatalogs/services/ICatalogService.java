package dinhgt.springboot.sbtrainingcatalogs.services;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;

public interface ICatalogService {

	CatalogDTO create(CatalogDTO catalog);
	
	
	CatalogDTO getById(String id);
	
}
