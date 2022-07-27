package com.r00t.itemserv.models.DTO.responsebody;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuantityUpdateDTO implements Serializable {
    private BigInteger quantity;
    private String itemID;
}
