package com.example.springrestapi.controllers.protectedControllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springrestapi.configurations.RequestConfig;
import com.example.springrestapi.models.CatalogItemDto;
import com.example.springrestapi.services.interfaces.CatalogItemService;

@RestController
@RequestMapping(RequestConfig.BASE_PROTECTED_URL + "/catalogs/{catalogId}/items")
public class CatalogItemController {

    @Autowired
    private CatalogItemService catalogItemService;

    @PostMapping
    public ResponseEntity<CatalogItemDto> createNewCatalogItem(@Valid @RequestBody CatalogItemDto body,
            @PathVariable(value = "catalogId") String catalogId) throws Exception {

        CatalogItemDto response = catalogItemService.createCatalogItem(body, catalogId);
        return new ResponseEntity<CatalogItemDto>(response, HttpStatus.OK);
    }

}
