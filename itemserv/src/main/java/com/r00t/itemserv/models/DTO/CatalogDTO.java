package com.r00t.itemserv.models.DTO;

import java.util.Date;
import java.util.List;

import com.r00t.itemserv.entities.Items;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogDTO {
    private String catalogID, catalogName, description;
    private List<Items> itemsList;
    private Date createdDate, updateDate;
    private boolean isDeleted;
}
