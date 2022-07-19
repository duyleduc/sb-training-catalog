package com.example.springrestapi.mappers;

import org.springframework.stereotype.Component;

import com.example.springrestapi.entities.Catalog;
import com.example.springrestapi.entities.CatalogItem;
import com.example.springrestapi.models.CatalogItemDto;

@Component
public class CatalogItemMapper {
    public CatalogItem toCatalogItem(CatalogItemDto dto, Catalog catalog) {
        return new CatalogItem(dto.getItemId(), dto.getItemName(), dto.getDescription(), catalog);
    }

    public CatalogItemDto toCatalogItemDto(CatalogItem catalogItem) {
        CatalogItemDto dto = new CatalogItemDto();
        dto.setItemId(catalogItem.getItemId());
        dto.setItemName(catalogItem.getItemName());
        dto.setDescription(catalogItem.getDescription());
        return dto;
    }

}
