package com.example.DemoSpringBoot.controllerz.privAte;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.EditItemDTO;
import com.example.DemoSpringBoot.models.DTO.ItemDTO;
import com.example.DemoSpringBoot.services.ItemServiceImpl;

@RestController
@Transactional
@RequestMapping("api/v1/protected/catalogs/{CatalogId}/items")
public class ItemController {
    @Autowired
    private ItemServiceImpl iService;

    @PostMapping(value = "")
    public ItemDTO createItem(@Valid @RequestBody ItemDTO itemDTO, @PathVariable BigInteger CatalogId) throws Exception {
        return iService.createItem(CatalogId, itemDTO);
    }

    @PutMapping(value = "/{itemID}")
    public ItemDTO putItem(@Valid @RequestBody EditItemDTO itemDTO, @PathVariable BigInteger CatalogId, @PathVariable BigInteger itemID) throws Exception {
        return iService.editItem(itemID, itemDTO, CatalogId);
    }
}
