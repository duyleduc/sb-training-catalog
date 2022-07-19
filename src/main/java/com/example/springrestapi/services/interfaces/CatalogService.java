package com.example.springrestapi.services.interfaces;

import java.util.List;
import com.example.springrestapi.models.CatalogDto;
import com.example.springrestapi.models.CatalogItemDto;

public interface CatalogService {
    CatalogDto createCatalog(CatalogDto dto) throws Exception;

    List<CatalogItemDto> getCatalogItems(String catalogId) throws Exception;

    List<CatalogDto> getCatalogs() throws Exception;
}
