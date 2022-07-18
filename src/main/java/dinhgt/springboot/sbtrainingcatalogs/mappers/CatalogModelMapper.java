package dinhgt.springboot.sbtrainingcatalogs.mappers;

import org.mapstruct.Mapper;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.model.Catalog;


@Mapper(componentModel = "spring")
public interface CatalogModelMapper {

	CatalogDTO catalogDTO(Catalog catalog);
	
	Catalog catalogDAO(CatalogDTO catalog);
}
