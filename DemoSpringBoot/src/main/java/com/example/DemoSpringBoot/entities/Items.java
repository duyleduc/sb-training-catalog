package com.example.DemoSpringBoot.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Items {

    @Id
    @Column(length = 8)
    @NotNull
    private String itemID;

    @Column(length = 64)
    @NotEmpty(message = "itemName is required")
    private String itemName;

    @Column(length = 64)
    @NotEmpty(message = "description is required")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "catalogid")
    private Catalogs catal0g;

    @Column
    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalogs getCatalogID() {
        return catal0g;
    }

    public void setCatalogID(Catalogs catalog) {
        this.catal0g = catalog;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

    public Items() {
    }

    public Items(String itemID,
            String itemName,
            String description,
            Catalogs catalog,
            Date createdDate) {
        super();
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.catal0g = catalog;
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

    
}
