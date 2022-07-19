package com.example.DemoSpringBoot.services;

import java.util.List;

import com.example.DemoSpringBoot.models.DTO.CatalogDTO;

public interface CatalogServiceImpl {

    CatalogDTO getCatalog(String id) throws Exception;
    List<CatalogDTO> getAllCatalogs() throws Exception;

    CatalogDTO createCatalog(CatalogDTO catalogDTO) throws Exception;

    CatalogDTO editCatalog(String id, CatalogDTO catalogDTO) throws Exception;


    CatalogDTO deleteCatalogDTO(String id) throws Exception;
}
