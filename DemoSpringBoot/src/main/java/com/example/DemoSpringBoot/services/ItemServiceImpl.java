package com.example.DemoSpringBoot.services;

import java.math.BigInteger;
import java.util.List;

import com.example.DemoSpringBoot.models.DTO.EditItemDTO;
import com.example.DemoSpringBoot.models.DTO.ItemDTO;

public interface ItemServiceImpl {
    ItemDTO getItem(BigInteger id) throws Exception;
    List<ItemDTO> getAllItems(BigInteger CatalogId) throws Exception;

    ItemDTO createItem(BigInteger catID, ItemDTO itemDTO) throws Exception;
    ItemDTO editItem(BigInteger id, EditItemDTO editItemDTO, BigInteger catID) throws Exception;

}
