package com.example.DemoSpringBoot.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemID", columnDefinition = "BIGSERIAL PRIMARY KEY NOT NULL")
    private BigInteger ID;

    @Column(length = 8, name = "item_id")
    @NotNull
    private String itemID;

    @Column(length = 64)
    @NotEmpty(message = "itemName is required")
    private String itemName;

    @Column(length = 64)
    @NotEmpty(message = "description is required")
    private String description;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "catalogID")
    private Catalogs catal0g;

    @Column(updatable = false)
    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column
    @UpdateTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date updateDate;

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

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger iD) {
        ID = iD;
    }

    public Catalogs getCatal0g() {
        return catal0g;
    }

    public void setCatal0g(Catalogs catal0g) {
        this.catal0g = catal0g;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Constructor
     */

    public Items() {
    }

    public Items(BigInteger iD, String itemID, String itemName,
            String description, Catalogs catal0g, Date createdDate,
            Date updateDate) {
        ID = iD;
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.catal0g = catal0g;
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
        this.updateDate = (updateDate != null) ? new Date(updateDate.getTime()) : new Date();
    }

}
