package com.example.DemoSpringBoot.controllerz.publIc;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DemoSpringBoot.models.DTO.CatalogDTO;
import com.example.DemoSpringBoot.services.CatalogServiceImpl;

@RestController
@RequestMapping("api/v1/public/catalogs")
public class CatalogPublicController {
    @Autowired
    private CatalogServiceImpl cService;

    @GetMapping(value = "")
    public List<CatalogDTO> getAllUsers() throws Exception {
        return cService.getAllCatalogs();
    }

    @GetMapping(value = "/{id}")
    public CatalogDTO getOneByID(@PathVariable BigInteger id) throws Exception {
        return cService.getCatalog(id);
    }
}
