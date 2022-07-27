package com.r00t.itemserv.controllerz.publIc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.r00t.itemserv.models.DTO.ItemDTO;
import com.r00t.itemserv.services.Impl.ItemServiceImpl;

@RestController
@RequestMapping("api/v1/public/items")
public class ItemPublicController {
    @Autowired
    private ItemServiceImpl iService;

    @GetMapping(value = "")
    public @ResponseBody List<ItemDTO> getAllItems(@RequestParam(name = "CatalogID", required = false) String CatalogID) throws Exception {
        return iService.getAllItems(CatalogID);
    }

    @GetMapping(value = "/{itemID}")
    public @ResponseBody ItemDTO getItem(@PathVariable String itemID ) throws Exception {
        return iService.getItem(itemID);
    }
}
