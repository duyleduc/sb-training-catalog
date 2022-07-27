package com.r00t.itemserv.models.DTO.requestbody;

import java.math.BigInteger;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateItemDTO {
    private BigInteger quantity;
    private String itemID, itemName, description;
    private String catalogID;
}
