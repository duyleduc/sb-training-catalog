package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Catalog;
import com.training.sbtrainingcatalog.exceptions.CatalogAlreadyExists;
import com.training.sbtrainingcatalog.repositories.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Override
    public List<Catalog> getCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public List<String> getCatalogIDs() {
        return catalogRepository.findAllCatalogID();
    }
    @Override
    public Catalog getCatalog(String catalogID) {
        return catalogRepository.findByCatalogID(catalogID);
    }

    @Override
    public Catalog saveCatalog(Catalog catalog) {

        Catalog catalogDB = catalogRepository.findByCatalogID(catalog.getCatalogID());
        if(catalogDB != null){
            throw  new CatalogAlreadyExists();
        }

        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog updateCatalog(Catalog catalog) {
        Catalog catalogDB = catalogRepository.findByCatalogID(catalog.getCatalogID());
        if(catalogDB==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        catalog.setCreatedDate(catalogDB.getCreatedDate());
        catalogRepository.save(catalog);

        return catalogRepository.findByCatalogID(catalog.getCatalogID());
    }

    @Override
    public String removeCatalog(String catalogID) {
        Catalog catalog = catalogRepository.findByCatalogID(catalogID);
        if(catalog==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        catalogRepository.delete(catalog);
        return catalogID;
    }
}
