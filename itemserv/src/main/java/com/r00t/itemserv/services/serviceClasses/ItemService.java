package com.r00t.itemserv.services.serviceClasses;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r00t.itemserv.entities.Catalogs;
import com.r00t.itemserv.entities.Items;
import com.r00t.itemserv.mappers.ItemMapper;
import com.r00t.itemserv.models.DTO.ItemDTO;
import com.r00t.itemserv.models.DTO.requestbody.CreateItemDTO;
import com.r00t.itemserv.models.DTO.requestbody.EditItemDTO;
import com.r00t.itemserv.repositories.CatalogRepository;
import com.r00t.itemserv.repositories.ItemRepository;
import com.r00t.itemserv.services.Impl.ItemServiceImpl;

@Service
public class ItemService implements ItemServiceImpl {

    @Autowired
    private ItemRepository iRepository;

    @Autowired
    private CatalogRepository cRepository;

    @Autowired
    private ItemMapper mapper;

    @Override
    public ItemDTO getItem(String itemID) throws Exception {
        try {
            Items item = iRepository.findByItemID(itemID).get();
            return mapper.item2DTO(item);
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public List<ItemDTO> getAllItems(String catalogID) throws Exception {
        // have catalogid query params
        if (catalogID != null) {
            try {
                Catalogs catalog = cRepository.findByCatalogID(catalogID).get();
                return mapper.items2DTOs(catalog.getItemsList());
            } catch (Exception exception) {
                throw exception;
            }
        } else {
            try {
                return mapper.items2DTOs(iRepository.findAll());

            } catch (Exception exception) {
                throw exception;
            }
        }
    }

    @Override
    public ItemDTO createItem(CreateItemDTO itemDTO) throws Exception {
        Catalogs catalog = ExistwCatalogID(itemDTO.getCatalogID());
        ValidItemID(itemDTO.getItemID());
        try {

            Items sampleItem = new Items();
            sampleItem.setItemID(itemDTO.getItemID());
            sampleItem.setItemName(itemDTO.getItemName());
            sampleItem.setDescription(itemDTO.getDescription());
            sampleItem.setCatal0g(catalog);
            sampleItem.setQuantity(itemDTO.getQuantity());

            Items returnItem = iRepository.save(sampleItem);
            return mapper.item2DTO(returnItem);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ItemDTO editItem(String itemID, EditItemDTO editItem) throws Exception {
        // Validate
        if (!itemID.equals(editItem.getItemID())) {
            ValidItemID(editItem.getItemID());
        }
        Catalogs newCatalogs = ExistwCatalogID(editItem.getCatalogID());
        try {
            Items item = iRepository.findByItemID(itemID).get();
            item.setCatal0g(newCatalogs);
            item.setItemID(editItem.getItemID());
            item.setItemName(editItem.getItemName());
            item.setDescription(editItem.getDescription());
            item.setQuantity(editItem.getQuantity());

            Items returnItem = iRepository.save(item);
            return mapper.item2DTO(returnItem);
        } catch (Exception e) {
            throw e;
        }
    }

    private Catalogs ExistwCatalogID(String catalogID) throws Exception {
        Optional<Catalogs> DBreturnCatalog = cRepository.findByCatalogID(catalogID);
        if (DBreturnCatalog.isEmpty()) {
            throw new NullPointerException(
                    "No Catalog with CatlogID: " + catalogID + " were found. Plz try KHALID");
        }
        return DBreturnCatalog.get();
    }

    private void ValidItemID(String itemID) throws Exception {
        Optional<Items> DBreturnItem = iRepository.findByItemID(itemID);
        if (DBreturnItem.isPresent()) {
            throw new EntityExistsException("Already got that Item with ItemID " + itemID + " dawg.");
        }
    }

    public void UpdateQuantity(String itemID, int quantity) throws Exception {
        try {
            Items DBreturnItem = iRepository.findByItemID(itemID).get();
            int newqty = DBreturnItem.getQuantity().intValue() - quantity;
            System.out.println(newqty);
            DBreturnItem.setQuantity(new BigInteger(String.valueOf(newqty)));

            iRepository.save(DBreturnItem);
        } catch (Exception e) {
            throw e;
        }
    }

}
