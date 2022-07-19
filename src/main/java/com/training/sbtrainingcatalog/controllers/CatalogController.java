package com.training.sbtrainingcatalog.controllers;

import com.training.sbtrainingcatalog.entities.Catalog;
import com.training.sbtrainingcatalog.models.CatalogDto;
import com.training.sbtrainingcatalog.services.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/protected/catalogs")
@RequiredArgsConstructor
@Slf4j
public class CatalogController {
    private final CatalogService catalogService;
    private final ModelMapper modelMapper;

    @PostMapping
    public CatalogDto saveCatalog(@RequestBody @Valid CatalogDto catalogDto){
        Catalog catalog = modelMapper.map(catalogDto,Catalog.class);
        Catalog catalogRes = catalogService.saveCatalog(catalog);
        CatalogDto catalogDtoRes = modelMapper.map(catalogRes,CatalogDto.class);
        return catalogDtoRes;
    }

    @GetMapping
    public List<CatalogDto> getCatalogs(){
        List<Catalog> catalogs = catalogService.getCatalogs();

        return catalogs.stream().map(catalog -> modelMapper.map(catalog,CatalogDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{catalogID}")
    public CatalogDto getCatalog(@PathVariable String catalogID){
        Catalog catalog = catalogService.getCatalog(catalogID);

        return  modelMapper.map(catalog,CatalogDto.class);
    }

    @PutMapping("{catalogID}")
    public CatalogDto updateCatalog(@PathVariable String catalogID, @RequestBody CatalogDto catalogDto){
        Catalog catalog = modelMapper.map(catalogDto,Catalog.class);
        catalog.setCatalogID(catalogID);
        Catalog catalogRes = catalogService.updateCatalog(catalog);
        CatalogDto catalogDtoRes = modelMapper.map(catalogRes,CatalogDto.class);
        return catalogDtoRes;
    }

    @DeleteMapping("{catalogID}")
    public String removeCatalog(@PathVariable String catalogID){

        return catalogService.removeCatalog(catalogID);
    }
}
