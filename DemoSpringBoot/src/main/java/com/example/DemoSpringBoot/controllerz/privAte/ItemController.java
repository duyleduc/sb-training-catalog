package com.example.DemoSpringBoot.controllerz.privAte;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.ItemDTO;
import com.example.DemoSpringBoot.services.ItemServiceImpl;

@RestController
@Transactional
@RequestMapping("api/v1/protected/catalogs/{CatalogId}/items")
public class ItemController {
    @Autowired
    private ItemServiceImpl iService;

    // @GetMapping(value = "")
    // public List<ItemDTO> getAllItems(@PathVariable String CatalogId) throws Exception {
    //     return iService.getAllItems(CatalogId);
    // }

    // @GetMapping(value = "/{id}")
    // public ItemDTO getItem(@PathVariable String id ) throws Exception {
    //     return iService.getItem(id);
    // }

    @PostMapping(value = "")
    public ItemDTO createItem(@Valid @RequestBody ItemDTO itemDTO, @PathVariable String CatalogId) throws Exception {
        return iService.createItem(CatalogId, itemDTO);
    }
}
