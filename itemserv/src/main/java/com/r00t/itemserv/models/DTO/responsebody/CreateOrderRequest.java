package com.r00t.itemserv.models.DTO.responsebody;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateOrderRequest {
    String itemID;
    int quantity;
}