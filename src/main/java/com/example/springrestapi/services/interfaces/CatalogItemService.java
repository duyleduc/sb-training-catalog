package com.example.springrestapi.services.interfaces;

import com.example.springrestapi.entities.CatalogItem;
import com.example.springrestapi.models.CatalogItemDto;

public interface CatalogItemService {
    CatalogItemDto createCatalogItem(CatalogItemDto dto, String catalogId) throws Exception;

    CatalogItem getCatalogItemById(String id) throws Exception;
}
