package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogService {
    List<Catalog> getCatalogs();

    List<Long> getCatalogIds();

    Catalog getCatalog(Long id);

    Catalog saveCatalog(Catalog catalog);
    Catalog updateCatalog(Catalog catalog,Long id);
    Long removeCatalog(Long id);
}
