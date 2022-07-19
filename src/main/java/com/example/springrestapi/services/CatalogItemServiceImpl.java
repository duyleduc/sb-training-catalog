package com.example.springrestapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.springrestapi.entities.Catalog;
import com.example.springrestapi.mappers.CatalogItemMapper;
import com.example.springrestapi.models.CatalogItemDto;
import com.example.springrestapi.repositories.CatalogItemRepository;
import com.example.springrestapi.repositories.CatalogRepository;
import com.example.springrestapi.services.interfaces.CatalogItemService;

@Service
public class CatalogItemServiceImpl implements CatalogItemService {

    @Autowired
    CatalogItemRepository catalogItemRepository;

    @Autowired
    CatalogRepository catalogRepository;

    @Autowired
    CatalogItemMapper catalogItemMapper;

    @Override
    @Transactional
    public CatalogItemDto createCatalogItem(CatalogItemDto dto, String catalogId) throws Exception {
        Optional<Catalog> catalog = catalogRepository.findById(catalogId);

        if (catalog.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Catalog with id:  " + catalogId + " does not exist");
        }

        if (!catalogItemRepository.existsById(dto.getItemId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Catalog item with id:  " + dto.getItemId() + " already exist");
        }

        catalogItemRepository.save(catalogItemMapper.toCatalogItem(dto, catalog.get()));
        return dto;
    }

}
