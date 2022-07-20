package com.training.sbtrainingcatalog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="item_id")
    private String itemID;

    @Column(name="item_name")
    @NotNull
    private String itemName;

    @Column(name="description")
    private String description;

//    @Column(name="catalog_id")
//    @NotNull
//    private String catalogID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @Column(name="created_date")
    private LocalDateTime createdDate;

    @Column(name="modify_date")
    private LocalDateTime modifyDate;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
}
