package com.example.springrestapi.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CatalogItemDto {
    @NotBlank
    @Size(max = 8)
    private String itemId;

    @Size(max = 64)
    @NotBlank
    private String itemName;

    @Size(max = 64)
    private String description;
}
