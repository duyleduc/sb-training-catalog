package com.example.springrestapi.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class CatalogItem {
    @Id
    @Column(length = 8)
    private String itemId;

    @Column(length = 64)
    private String itemName;

    @Column(length = 64)
    private String description;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;

    @CreatedDate
    private Instant createdDate;

    public CatalogItem(String id, String name, String description, Catalog catalog) {
        this.itemId = id;
        this.itemName = name;
        this.description = description;
        this.createdDate = Instant.now();
        this.catalog = catalog;
    }

}
