package com.example.DemoSpringBoot.services;

import java.util.List;

import com.example.DemoSpringBoot.models.DTO.ItemDTO;

public interface ItemServiceImpl {
    ItemDTO getItem(String id) throws Exception;
    List<ItemDTO> getAllItems(String CatalogId) throws Exception;

    ItemDTO createItem(String CatalogID, ItemDTO item) throws Exception;
}
