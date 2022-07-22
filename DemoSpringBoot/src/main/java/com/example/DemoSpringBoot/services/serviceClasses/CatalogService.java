package com.example.DemoSpringBoot.services.serviceClasses;

import java.io.File;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.Catalogs;
import com.example.DemoSpringBoot.mappers.CatalogMapper;
import com.example.DemoSpringBoot.models.DTO.CatalogDTO;
import com.example.DemoSpringBoot.repositories.CatalogRepository;
import com.example.DemoSpringBoot.services.CatalogServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatalogService implements CatalogServiceImpl {

    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Autowired
    CatalogMapper mapper;

    @Autowired
    CatalogRepository repository;

    @Override
    public CatalogDTO getCatalog(BigInteger id) throws Exception {
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
        if (repository.IsCataLog(catalogDTO.getCatalogID())) {
            throw new Exception("Catalog already exist. If you wanna edit plz use PUT METHOD.");
        }
        try {
            Catalogs catalog = repository.save(mapper.DTO2Catalog(catalogDTO));
            return mapper.catalog2DTO(catalog);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CatalogDTO editCatalog(BigInteger id, CatalogDTO editInfo) throws Exception {
        // check Catalog exist with String CatalogID
        if (repository.IsCataLog(editInfo.getCatalogID())) {
            Catalogs dBCatalogs = repository.findByCatalogID(editInfo.getCatalogID()).get();
            BigInteger DatabaseID = dBCatalogs.getID();
            // String DatabaseName =  dBCatalogs.getCatalogName();
            // check Catalog String id & PK id
            if (DatabaseID.intValue() == id.intValue()) {
                throw new Exception("Already edit the Catalog with id: " + id + ".");
            } else {
                throw new Exception("This CatalogID is already exist. Plz choose different Name");
            }
        }
        try {
            Catalogs catalog = repository.findById(id).get();

            catalog.setCatalogID(editInfo.getCatalogID());
            catalog.setCatalogName(editInfo.getCatalogName());
            catalog.setDescription(editInfo.getDescription());
            catalog.setUpdateDate(new Date());

            repository.save(catalog);

            return mapper.catalog2DTO(catalog);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public CatalogDTO deleteCatalogDTO(BigInteger id) throws Exception {
        return null;
    }

    @Override
    public List<CatalogDTO> seedCatalogs() throws Exception {
        List<CatalogDTO> CatalogDTOsList = objectMapper.readValue(new File("DemoSpringBoot/src/main/java/com/example/DemoSpringBoot/templates/seeds/CatalogSeed.json"),
                new TypeReference<List<CatalogDTO>>() {
                });
        repository.saveAll(mapper.DTOs2Catalogs(CatalogDTOsList));
        return getAllCatalogs();
    }

}
