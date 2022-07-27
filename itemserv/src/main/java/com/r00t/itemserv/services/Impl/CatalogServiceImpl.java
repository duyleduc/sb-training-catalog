package com.r00t.itemserv.services.Impl;

import java.util.List;

import com.r00t.itemserv.models.DTO.CatalogDTO;

public interface CatalogServiceImpl {

    CatalogDTO getCatalog(String catalogID) throws Exception;
    List<CatalogDTO> getAllCatalogs() throws Exception;

    CatalogDTO createCatalog(CatalogDTO catalogDTO) throws Exception;

    CatalogDTO editCatalog(String catalogID, CatalogDTO catalogDTO) throws Exception;


    CatalogDTO deleteCatalogDTO(String catalogID) throws Exception;
}
