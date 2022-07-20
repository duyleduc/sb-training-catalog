package com.training.sbtrainingcatalog.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name="catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="catalog_id")
    private String catalogID;

    @Column(name = "catalog_name")
    @NotNull
    private String catalogName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @OneToMany( cascade = CascadeType.ALL,mappedBy = "catalog", fetch = FetchType.EAGER)
//    @JoinColumn(name="catalog_id")
    private List<Product> products;

    public void add(Product product){
        if(products==null){
            products = new ArrayList<>();
        }
        products.add(product);
    }

    public List<Product> getProducts() {
        return this.products == null ? null : new ArrayList<>(this.products);
    }

    public void setProducts(List<Product> products) {
        if (products == null) {
            this.products = null;
        } else {
            this.products = Collections.unmodifiableList(products);
        }
    }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
}
