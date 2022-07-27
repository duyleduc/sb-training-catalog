package dinhgt.springboot.sbtrainingcatalogs.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.exception.catalog.CatalogCreateException;
import dinhgt.springboot.sbtrainingcatalogs.exception.catalog.CatalogUpdateException;
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

		boolean isExits = catalogRepository.existsByCatalogIdAndIsActivated(catalog.getCatalogId(), true);
		if (isExits)
			throw new CatalogCreateException("Duplicate id catalog!");

		isExits = catalogRepository.existsByCatalogIdAndIsActivated(catalog.getCatalogName(), true);
		if (isExits)
			throw new CatalogCreateException("Duplicate name catalog!");

		catalog.setCreatedDate(LocalDateTime.now());
		catalog.setActivated(true);

		Catalog catalogDAO = catalogRepository.save(catalogModelMapper.catalogDAO(catalog));
		return catalogModelMapper.catalogDTO(catalogDAO);
	}

	@Override
	public CatalogDTO getById(int id) {
		Optional<Catalog> isExits = catalogRepository.findByIdAndIsActivated(id, true);
		System.out.println(isExits.isPresent());
		if (!isExits.isPresent())
			throw new CatalogCreateException(" Cannot find catalog with id: " + id);

		return catalogModelMapper.catalogDTO(isExits.get());
	}

	@Override
	public CatalogDTO getCatalog(String id) {
		boolean isExits = catalogRepository.existsByCatalogIdAndIsActivated(id, true);
		if (!isExits)
			throw new CatalogCreateException(" Cannot find catalog with id: " + id);

		Catalog catalog = catalogRepository.getReferenceByCatalogIdAndIsActivated(id, true);
		return catalogModelMapper.catalogDTO(catalog);
	}

	@Override
	public List<CatalogDTO> getAllCatalog() {
		List<Catalog> listCatalog = catalogRepository.findAllByIsActivated(true);
		return catalogModelMapper.listCatalogDTO(listCatalog);
	}

	@Override
	public CatalogDTO updateCatalog(CatalogDTO catalogDTO, int id) {

		if (Integer.compare(catalogDTO.getId(), id) != 0)
			throw new CatalogUpdateException("Id not match!");

		boolean isExits = catalogRepository.existsByCatalogIdAndIsActivated(catalogDTO.getCatalogId(), true);
		if (isExits)
			throw new CatalogCreateException("Duplicate id catalog!");

		isExits = catalogRepository.existsByCatalogIdAndIsActivated(catalogDTO.getCatalogName(), true);
		if (isExits)
			throw new CatalogCreateException("Duplicate name catalog!");
		Optional<Catalog> optionCatalog = catalogRepository.findByIdAndIsActivated(id, true);
		if (!optionCatalog.isPresent())
			throw new CatalogUpdateException("Cannot find catalog with id: " + id);

		Catalog catalog = optionCatalog.get();
		customMapping(catalogDTO, catalog);
		Catalog result = catalogRepository.save(catalog);
		return catalogModelMapper.catalogDTO(result);
	}

	public void customMapping(CatalogDTO catalogDTO, Catalog catalog) {
		if (catalogDTO.getCatalogId() != null)
			catalog.setCatalogId(catalogDTO.getCatalogId());
		if (catalogDTO.getCatalogName() != null)
			catalog.setCatalogName(catalogDTO.getCatalogName());
		if (catalogDTO.getDescription() != null)
			catalog.setDescription(catalogDTO.getDescription());
		catalog.setModifyDate(LocalDateTime.now());
	}

}
