package com.r00t.itemserv.services.Impl;

import java.util.List;

import com.r00t.itemserv.models.DTO.ItemDTO;
import com.r00t.itemserv.models.DTO.requestbody.CreateItemDTO;
import com.r00t.itemserv.models.DTO.requestbody.EditItemDTO;

public interface ItemServiceImpl {
    ItemDTO getItem(String itemID) throws Exception;
    List<ItemDTO> getAllItems(String catalogID) throws Exception;

    ItemDTO createItem(CreateItemDTO itemDTO) throws Exception;
    ItemDTO editItem(String itemID, EditItemDTO editItemDTO) throws Exception;

}
