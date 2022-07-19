package com.example.springrestapi.controllers.protectedControllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springrestapi.configurations.RequestConfig;
import com.example.springrestapi.models.CatalogDto;
import com.example.springrestapi.models.CatalogItemDto;
import com.example.springrestapi.services.interfaces.CatalogService;

@RestController
@RequestMapping(RequestConfig.BASE_PROTECTED_URL + "/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    public ResponseEntity<List<CatalogDto>> getCatalogs() throws Exception {
        List<CatalogDto> response = catalogService.getCatalogs();
        return new ResponseEntity<List<CatalogDto>>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CatalogDto> createNewCatalog(@Valid @RequestBody CatalogDto body) throws Exception {
        CatalogDto response = catalogService.createCatalog(body);
        return new ResponseEntity<CatalogDto>(response, HttpStatus.OK);
    }

    @GetMapping(value = "{id}/items")
    public ResponseEntity<List<CatalogItemDto>> getItems(@PathVariable(value = "id") String id) throws Exception {
        List<CatalogItemDto> response = catalogService.getCatalogItems(id);
        return new ResponseEntity<List<CatalogItemDto>>(response, HttpStatus.OK);
    }

}
