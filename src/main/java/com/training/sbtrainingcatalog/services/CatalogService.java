package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Catalog;

import java.util.List;

public interface CatalogService {
    List<Catalog> getCatalogs();

    List<String> getCatalogIDs();

    Catalog getCatalog(String catalogID);
    Catalog saveCatalog(Catalog catalog);
    Catalog updateCatalog(Catalog catalog);
    String removeCatalog(String catalogID);
}
