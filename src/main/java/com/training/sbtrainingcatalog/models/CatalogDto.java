package com.training.sbtrainingcatalog.models;

import com.training.sbtrainingcatalog.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatalogDto {

    private long id;

    @NotEmpty(message = "ID shouldn't be empty")
    @Size( max = 8, message = "ID is no more than 8 characters")
    private String catalogID;

    @NotEmpty(message = "Catalog name shouldn't be empty")
    @Size( max = 64, message = "Catalog name shouldn't more than 64 characters")
    private String catalogName;

    @Size( max = 64, message = "description shouldn't more than 64 characters")
    private String description;

    private LocalDateTime createdDate;

    private List<ProductDto> products;

    private LocalDateTime modifyDate ;
}
