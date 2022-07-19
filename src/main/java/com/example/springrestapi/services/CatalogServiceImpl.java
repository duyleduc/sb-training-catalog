package com.example.springrestapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.springrestapi.entities.Catalog;
import com.example.springrestapi.mappers.CatalogItemMapper;
import com.example.springrestapi.mappers.CatalogMapper;
import com.example.springrestapi.models.CatalogDto;
import com.example.springrestapi.models.CatalogItemDto;
import com.example.springrestapi.repositories.CatalogRepository;
import com.example.springrestapi.services.interfaces.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Autowired
    private CatalogMapper catalogMapper;

    @Autowired
    private CatalogItemMapper catalogItemMapper;

    @Override
    @Transactional
    public CatalogDto createCatalog(CatalogDto dto) throws Exception {
        getCatalogById(dto.getCatalogId());
        catalogRepository.save(catalogMapper.toCatalog(dto));
        return dto;
    }

    @Override
    public List<CatalogItemDto> getCatalogItems(String catalogId) throws Exception {

        Catalog catalog = getCatalogById(catalogId);
        return catalog.getCatalogItems().stream().map(x -> catalogItemMapper.toCatalogItemDto(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<CatalogDto> getCatalogs() throws Exception {
        return catalogRepository.findAll().stream().map(x -> catalogMapper.toCatalogDto(x))
                .collect(Collectors.toList());
    }

    @Override
    public Catalog getCatalogById(String id) throws Exception {
        Optional<Catalog> catalog = catalogRepository.findById(id);
        if (catalog.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Catalog with id: " + id + "  does not exist");
        }
        return catalog.get();
    }

}
