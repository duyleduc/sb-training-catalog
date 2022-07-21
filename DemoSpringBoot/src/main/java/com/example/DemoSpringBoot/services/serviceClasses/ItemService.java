package com.example.DemoSpringBoot.services.serviceClasses;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DemoSpringBoot.entities.Catalogs;
import com.example.DemoSpringBoot.entities.Items;
import com.example.DemoSpringBoot.mappers.ItemMapper;
import com.example.DemoSpringBoot.models.DTO.EditItemDTO;
import com.example.DemoSpringBoot.models.DTO.ItemDTO;
import com.example.DemoSpringBoot.repositories.CatalogRepository;
import com.example.DemoSpringBoot.repositories.ItemRepository;
import com.example.DemoSpringBoot.services.ItemServiceImpl;

@Service
public class ItemService implements ItemServiceImpl {

    @Autowired
    private ItemRepository iRepository;

    @Autowired
    private CatalogRepository cRepository;

    @Autowired
    private ItemMapper mapper;

    @Override
    public ItemDTO getItem(BigInteger ItemID) throws Exception {
        try {
            Items item = iRepository.findById(ItemID).get();
            return mapper.item2DTO(item);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public List<ItemDTO> getAllItems(BigInteger CatalogId) throws Exception {
        try {
            Catalogs catalog = cRepository.findById(CatalogId).get();
            return mapper.items2DTOs(catalog.getItems());
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public ItemDTO createItem(BigInteger catID, ItemDTO itemDTO) throws Exception {
        try {
            Catalogs catalog = cRepository.findById(catID).get();
            Items sampleItem = new Items();
            sampleItem.setItemID(itemDTO.getItemID());
            sampleItem.setItemName(itemDTO.getItemName());
            sampleItem.setDescription(itemDTO.getDescription());
            sampleItem.setCatal0g(catalog);

            iRepository.save(sampleItem);

            return mapper.item2DTO(sampleItem);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public ItemDTO editItem(BigInteger ItemID, EditItemDTO editItemDTO, BigInteger CatalogId) throws Exception {
        
        
        try {
            Catalogs newcatalog = cRepository.findByCatalogID(editItemDTO.getCatalogID()).get();
            Items sampleItem = iRepository.findById(ItemID).get();
            if(sampleItem.getCatal0g().getID().intValue() != CatalogId.intValue()){
                throw new Exception("This Item is not from this Catalog. Check your CatalogID");
            }
            
            sampleItem.setItemID(editItemDTO.getItemID());
            sampleItem.setItemName(editItemDTO.getItemName());
            sampleItem.setDescription(editItemDTO.getDescription());
            sampleItem.setCatal0g(newcatalog);
            
            iRepository.save(sampleItem);

            return mapper.item2DTO(sampleItem);
        } catch (Exception e) {
            throw e;
        }
    }

}
