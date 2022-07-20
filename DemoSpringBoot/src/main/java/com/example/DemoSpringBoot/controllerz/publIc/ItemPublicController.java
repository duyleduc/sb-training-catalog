package com.example.DemoSpringBoot.controllerz.publIc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.ItemDTO;
import com.example.DemoSpringBoot.services.ItemServiceImpl;

@RestController
@RequestMapping("api/v1/public/catalogs/{CatalogID}/items")
public class ItemPublicController {
    @Autowired
    private ItemServiceImpl iService;

    @GetMapping(value = "")
    public List<ItemDTO> getAllItems(@PathVariable String CatalogId) throws Exception {
        return iService.getAllItems(CatalogId);
    }

    @GetMapping(value = "/{id}")
    public ItemDTO getItem(@PathVariable String id ) throws Exception {
        return iService.getItem(id);
    }
}
