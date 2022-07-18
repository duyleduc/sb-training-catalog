package dinhgt.springboot.sbtrainingcatalogs.services.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.exception.catalog.CatalogCreateException;
import dinhgt.springboot.sbtrainingcatalogs.mappers.CatalogModelMapper;
import dinhgt.springboot.sbtrainingcatalogs.model.Catalog;
import dinhgt.springboot.sbtrainingcatalogs.repositories.CatalogRepository;
import dinhgt.springboot.sbtrainingcatalogs.services.ICatalogService;
import dinhgt.springboot.sbtrainingcatalogs.validate.catalog.CatalogCreateValidate;

@Service
public class CatalogService implements ICatalogService {

	@Autowired
	private CatalogRepository catalogRepository;

	@Autowired
	private CatalogModelMapper catalogModelMapper;

	@Override
	public CatalogDTO create(CatalogDTO catalog) {
		
		CatalogCreateValidate.validate(catalog);
		catalog.setCreatedDate(LocalDateTime.now());

		boolean isExits = catalogRepository.existsById(catalog.getCatalogId());
		if (isExits) throw new CatalogCreateException("Duplicate id catalog!");
		
		Catalog catalogDAO = catalogRepository.save(catalogModelMapper.catalogDAO(catalog));

		return catalogModelMapper.catalogDTO(catalogDAO);
	}

	@Override
	public CatalogDTO getById(String id) {
		boolean isExits = catalogRepository.existsById(id);
		if (!isExits) throw new CatalogCreateException(" Cannot find catalog with id: " + id);
		
		Catalog catalog = catalogRepository.getReferenceById(id);
		return catalogModelMapper.catalogDTO(catalog);
	}

}
