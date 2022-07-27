package com.r00t.itemserv.services.serviceClasses;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r00t.itemserv.entities.Catalogs;
import com.r00t.itemserv.mappers.CatalogMapper;
import com.r00t.itemserv.models.DTO.CatalogDTO;
import com.r00t.itemserv.repositories.CatalogRepository;
import com.r00t.itemserv.services.Impl.CatalogServiceImpl;

@Service
public class CatalogService implements CatalogServiceImpl {

    @Autowired
    CatalogMapper mapper;

    @Autowired
    CatalogRepository repository;

    @Override
    public CatalogDTO getCatalog(String CatalogID) throws Exception {
        try {
            Optional<Catalogs> catalog = repository.findByCatalogID(CatalogID);
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
        // check existence
        if (repository.findByCatalogID(catalogDTO.getCatalogID()).isPresent()) {
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
    public CatalogDTO editCatalog(String CatalogID, CatalogDTO editInfo) throws Exception {
        Optional<Catalogs> DBCatalog = repository.findByCatalogID(CatalogID);
        if (DBCatalog.isEmpty()) {
            throw new Exception("No Catalog found with CatalogID: " + CatalogID);
        }
        Optional<Catalogs> isCatalogwithsameID = repository.findByCatalogID(editInfo.getCatalogID());
        if (isCatalogwithsameID.isPresent()) {
            throw new Exception(
                    "The CatalogID " + editInfo.getCatalogID() + " is already exist. Plz try different one");
        }
        try {
            DBCatalog.get().setCatalogID(editInfo.getCatalogID());
            DBCatalog.get().setCatalogName(editInfo.getCatalogName());
            DBCatalog.get().setDescription(editInfo.getDescription());
            DBCatalog.get().setUpdateDate(new Date());

            repository.save(DBCatalog.get());

            return mapper.catalog2DTO(DBCatalog.get());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public CatalogDTO deleteCatalogDTO(String CatalogID) throws Exception {
        return null;
    }
}
