package com.example.springrestapi.services.interfaces;

import com.example.springrestapi.models.CatalogItemDto;

public interface CatalogItemService {
    CatalogItemDto createCatalogItem(CatalogItemDto dto, String catalogId) throws Exception;
}
