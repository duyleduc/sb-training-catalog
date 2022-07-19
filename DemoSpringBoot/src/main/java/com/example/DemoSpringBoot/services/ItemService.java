package com.example.DemoSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.Catalogs;
import com.example.DemoSpringBoot.entities.Items;
import com.example.DemoSpringBoot.mappers.ItemMapper;
import com.example.DemoSpringBoot.models.DTO.ItemDTO;
import com.example.DemoSpringBoot.repositories.CatalogRepository;
import com.example.DemoSpringBoot.repositories.ItemRepository;

@Service
public class ItemService implements ItemServiceImpl {

    @Autowired
    private ItemRepository iRepository;

    @Autowired
    private CatalogRepository cRepository;

    @Autowired
    private ItemMapper mapper;

    @Override
    public ItemDTO getItem(String id) throws Exception {
        try {
            Items item = iRepository.findById(id).get();
            return mapper.item2DTO(item);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public List<ItemDTO> getAllItems(String CatalogId) throws Exception {
        try {
            Catalogs catalog = cRepository.findById(CatalogId).get();
            return mapper.items2DTOs(catalog.getItems());
        } catch (Exception exception) {
            throw exception;
        }

    }

    @Override
    public ItemDTO createItem(String CatalogID, ItemDTO itemDTO) throws Exception {
        try {
            Catalogs catalog = cRepository.findById(CatalogID).get();
            Items sampleItem = new Items(
                itemDTO.getItemID(),
                itemDTO.getItemName(),
                itemDTO.getDescription(),
                catalog,
                itemDTO.getCreatedDate()
            );
           iRepository.save(sampleItem);

            return mapper.item2DTO(sampleItem);
        } catch (Exception e) {
            throw e;
        }
    }

}
