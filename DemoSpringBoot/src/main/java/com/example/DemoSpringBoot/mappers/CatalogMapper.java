package com.example.DemoSpringBoot.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.example.DemoSpringBoot.entities.Catalogs;
import com.example.DemoSpringBoot.models.DTO.CatalogDTO;

@Mapper(componentModel = "spring")
@Component
public interface CatalogMapper {
    CatalogMapper INSTANCE = Mappers.getMapper(CatalogMapper.class);

    CatalogDTO catalog2DTO(Catalogs Catalog);

    List<CatalogDTO> catalogs2DTOs(List<Catalogs> Catalogs);

    @InheritInverseConfiguration
    Catalogs DTO2Catalog(CatalogDTO CatalogDTO);

    List<Catalogs> DTOs2Catalogs(List<CatalogDTO> catalogDTOs);
}
