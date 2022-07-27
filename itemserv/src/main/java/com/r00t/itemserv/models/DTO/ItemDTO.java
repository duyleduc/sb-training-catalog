package com.r00t.itemserv.models.DTO;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDTO {
    private BigInteger id, quantity;
    private String itemID, itemName, description;
    // private CatalogDTO catalogDTO;
    // private Catalogs catal0g;
    private Date createdDate, updateDate;
    private boolean isDeleted;
}
