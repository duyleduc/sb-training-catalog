package com.training.sbtrainingcatalog.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name="catalog")
public class Catalog {
    @Id
    @Column(name="catalog_id")
    private String catalogID;

    @Column(name = "catalog_name")
    @NotNull
    private String catalogName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany( cascade = CascadeType.ALL,mappedBy = "catalog", orphanRemoval = true,fetch = FetchType.EAGER)
//    @JoinColumn(name="catalog_id")
    private List<Product> products;

    public void add(Product product){
        if(products==null){
            products = new ArrayList<>();
        }
        products.add(product);
    }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
}
