package com.r00t.itemserv.controllerz.privAte;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r00t.itemserv.models.DTO.ItemDTO;
import com.r00t.itemserv.models.DTO.requestbody.CreateItemDTO;
import com.r00t.itemserv.models.DTO.requestbody.EditItemDTO;
import com.r00t.itemserv.services.Impl.ItemServiceImpl;

@RestController
@Transactional
@RequestMapping("api/v1/protected/items")
public class ItemController {
    @Autowired
    private ItemServiceImpl iService;

    @PostMapping(value = "")
    public ItemDTO createItem( @Valid @RequestBody CreateItemDTO itemDTO) throws Exception {
        return iService.createItem(itemDTO);
    }

    @PutMapping(value = "/{itemID}")
    public ItemDTO updateItem(@PathVariable String itemID, @Valid @RequestBody EditItemDTO itemDTO)
            throws Exception {
        return iService.editItem(itemID, itemDTO);
    }
}
