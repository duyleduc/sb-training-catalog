package com.r00t.itemserv.models.DTO.requestbody;

import java.math.BigInteger;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EditItemDTO {
    private String itemID;
    private String itemName;
    private String description;
    private String catalogID;  
    private BigInteger quantity;  
}
