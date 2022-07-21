package com.example.DemoSpringBoot.services;

import java.math.BigInteger;
import java.util.List;

import com.example.DemoSpringBoot.models.DTO.CatalogDTO;

public interface CatalogServiceImpl {

    CatalogDTO getCatalog(BigInteger id) throws Exception;
    List<CatalogDTO> getAllCatalogs() throws Exception;

    CatalogDTO createCatalog(CatalogDTO catalogDTO) throws Exception;

    CatalogDTO editCatalog(BigInteger id, CatalogDTO catalogDTO) throws Exception;


    CatalogDTO deleteCatalogDTO(BigInteger id) throws Exception;

    List<CatalogDTO> seedCatalogs() throws Exception;
}
