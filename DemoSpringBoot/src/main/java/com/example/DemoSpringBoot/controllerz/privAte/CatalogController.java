package com.example.DemoSpringBoot.controllerz.privAte;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.CatalogDTO;
import com.example.DemoSpringBoot.services.CatalogServiceImpl;

@RestController
@Transactional 
@RequestMapping("api/v1/protected/catalogs")
public class CatalogController {

    @Autowired
    private CatalogServiceImpl cService;

    // @GetMapping(value = "")
    // public List<CatalogDTO> getAllUsers() throws Exception {
    //     return cService.getAllCatalogs();
    // }

    // @GetMapping(value = "/{id}")
    // public CatalogDTO getOneByID(@PathVariable String id) throws Exception {
    //     return cService.getCatalog(id);
    // }

    @PostMapping(value = "")
    public CatalogDTO postUser(@Valid @RequestBody CatalogDTO catalogDTO) throws Exception {
        return cService.createCatalog(catalogDTO);
    }

    @PutMapping(value = "/{id}")
    public CatalogDTO editUser(@Valid @RequestBody CatalogDTO catalogDTO, @PathVariable String id) throws Exception {
        return cService.editCatalog(id, catalogDTO);
    }

    
}
