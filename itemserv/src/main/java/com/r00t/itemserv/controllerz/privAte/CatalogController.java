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

import com.r00t.itemserv.models.DTO.CatalogDTO;
import com.r00t.itemserv.services.Impl.CatalogServiceImpl;

@RestController
@Transactional
@RequestMapping("api/v1/protected/catalogs")
public class CatalogController {
    @Autowired
    private CatalogServiceImpl cService;

    @PostMapping(value = "")
    public CatalogDTO postUser(@Valid @RequestBody CatalogDTO catalogDTO) throws Exception {
        return cService.createCatalog(catalogDTO);
    }

    @PutMapping(value = "/{CatalogID}")
    public CatalogDTO editUser(@Valid @RequestBody CatalogDTO catalogDTO, @PathVariable String CatalogID)
            throws Exception {
        return cService.editCatalog(CatalogID, catalogDTO);
    }

}
