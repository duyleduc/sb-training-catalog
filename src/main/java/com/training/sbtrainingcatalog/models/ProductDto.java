package com.training.sbtrainingcatalog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private Long id;

    @NotEmpty(message = "ID shouldn't be empty")
    @Size( max = 8, message = "ID is no more than 8 characters")
    private String itemID;

    @NotEmpty(message = "Product name shouldn't be empty")
    @Size( max = 64, message = "Product name shouldn't more than 64 characters")
    private String itemName;

    @Size( max = 64, message = "description shouldn't more than 64 characters")
    private String description;

    @NotEmpty(message = "quantity shouldn't be empty")
    @Pattern(regexp="[0-9]+",message = "quantity should be number")
    private String quantity;

    private Long catalogId;

    private LocalDateTime createdDate;
    private LocalDateTime modifyDate;
}
