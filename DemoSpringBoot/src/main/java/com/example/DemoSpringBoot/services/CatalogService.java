package com.example.DemoSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.Catalogs;
import com.example.DemoSpringBoot.mappers.CatalogMapper;
import com.example.DemoSpringBoot.models.DTO.CatalogDTO;
import com.example.DemoSpringBoot.repositories.CatalogRepository;

@Service
public class CatalogService implements CatalogServiceImpl {

    @Autowired
    CatalogMapper mapper;

    @Autowired
    CatalogRepository repository;

    @Override
    public CatalogDTO getCatalog(String id) throws Exception {
        try {
            Optional<Catalogs> catalog = repository.findById(id);
            return mapper.catalog2DTO(catalog.get());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<CatalogDTO> getAllCatalogs() throws Exception {
        try {
            List<Catalogs> catalogs = repository.findAll();
            return mapper.catalogs2DTOs(catalogs);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CatalogDTO createCatalog(CatalogDTO catalogDTO) throws Exception {
        if(repository.existsById(catalogDTO.getCatalogID())){
            throw new Exception("User already exist. If you wanna edit plz use PUT METHOD.");
        }
        try {
            Catalogs catalog = repository.save(mapper.DTO2Catalog(catalogDTO));
            return mapper.catalog2DTO(catalog);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CatalogDTO editCatalog(String id, CatalogDTO editInfo) throws Exception {
        try {
            Catalogs catalog = repository.findById(id).get();
            
                catalog.setCatalogID(editInfo.getCatalogID());
                catalog.setCatalogName(editInfo.getCatalogName());
                catalog.setDescription(editInfo.getDescription());

            repository.save(catalog);

            return mapper.catalog2DTO(catalog);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public CatalogDTO deleteCatalogDTO(String id) throws Exception {
        return null;
    }

}
