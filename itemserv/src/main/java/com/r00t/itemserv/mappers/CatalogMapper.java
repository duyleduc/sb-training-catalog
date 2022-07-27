package com.r00t.itemserv.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.r00t.itemserv.entities.Catalogs;
import com.r00t.itemserv.models.DTO.CatalogDTO;

@Mapper(componentModel = "spring")
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    CatalogDTO catalog2DTO(Catalogs Catalog);

    List<CatalogDTO> catalogs2DTOs(List<Catalogs> Catalogs);

    @InheritInverseConfiguration
    Catalogs DTO2Catalog(CatalogDTO CatalogDTO);

    List<Catalogs> DTOs2Catalogs(List<CatalogDTO> catalogDTOs);
}
