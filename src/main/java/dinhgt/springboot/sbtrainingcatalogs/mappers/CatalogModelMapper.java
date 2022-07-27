package dinhgt.springboot.sbtrainingcatalogs.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.model.Catalog;


@Mapper(componentModel = "spring")
public interface CatalogModelMapper {

	CatalogDTO catalogDTO(Catalog catalog);
	
	Catalog catalogDAO(CatalogDTO catalog);
	
	List<CatalogDTO> listCatalogDTO(List<Catalog> listCatalog);
	
	List<Catalog> listCatalogDAO(List<CatalogDTO> listCatalog);
}
