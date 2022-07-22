package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Catalog;
import com.training.sbtrainingcatalog.exceptions.ResourceIsAlreadyTakenException;
import com.training.sbtrainingcatalog.exceptions.ResourceNotFoundException;
import com.training.sbtrainingcatalog.repositories.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
    public List<Long> getCatalogIds() {
        return catalogRepository.findAllCatalogId();
    }
    @Override
    public Catalog getCatalog(Long id) {
        Catalog catalog = catalogRepository.findCatalogById(id);
        if(catalog == null){
            throw new ResourceNotFoundException("Catalog", "id", id);
        }

        return catalog;
    }

    @Override
    public Catalog saveCatalog(Catalog catalog) {

        Catalog catalogDB = catalogRepository.findByCatalogID(catalog.getCatalogID());
        if(catalogDB != null){
            throw new ResourceIsAlreadyTakenException("Catalog", "CatalogID", catalog.getCatalogID());
        }

        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog updateCatalog(Catalog catalog,Long id) {
        Catalog catalogDB = catalogRepository.findCatalogById(id);
        if(catalogDB==null){
            throw new ResourceNotFoundException("Catalog", "id", id);
        }
        Catalog catalogByNewExistInDB = catalogRepository.findByCatalogID(catalog.getCatalogID());
        if(catalogByNewExistInDB!=null && catalogByNewExistInDB.getId() != catalogDB.getId()){
            throw new ResourceIsAlreadyTakenException("Catalog", "CatalogID", catalog.getCatalogID());
        }

        catalogDB.setCatalogID(catalog.getCatalogID());
        catalogDB.setCatalogName(catalog.getCatalogName());
        catalogDB.setModifyDate(LocalDateTime.now());

        Catalog catalogUpdate = catalogRepository.save(catalogDB);

        return catalogUpdate;
    }

    @Override
    public Long removeCatalog(Long id) {
        Catalog catalog = catalogRepository.findCatalogById(id);
        if(catalog==null){
            throw new ResourceNotFoundException("Catalog", "id", id);
        }
        catalogRepository.delete(catalog);
        return id;
    }
}
