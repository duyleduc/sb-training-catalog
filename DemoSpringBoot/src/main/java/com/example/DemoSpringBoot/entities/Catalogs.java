package com.example.DemoSpringBoot.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Catalogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogID", columnDefinition = "BIGSERIAL NOT NULL")
    private BigInteger ID;

    @Column(length = 8, name = "catalog_id")
    @NotNull
    private String catalogID;

    @OneToMany(mappedBy = "catal0g", cascade = { CascadeType.ALL })
    private List<Items> itemsList;

    @Column(length = 64)
    @NotNull
    private String catalogName;

    @Column(length = 64)
    private String description;

    @Column(updatable = false)
    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column
    @UpdateTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date updateDate;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
    
    public String getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

    public List<Items> getItems() {
        return itemsList;
    }

    public void setItems(List<Items> items) {
        this.itemsList = items;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = (updateDate != null) ? new Date(updateDate.getTime()) : new Date();
    }

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger iD) {
        ID = iD;
    }
    
    /**
     * Constructor
     */
    public Catalogs() {
    }

    public Catalogs(BigInteger ID, String catalogID, List<Items> itemsList, @NotNull String catalogName, String description,
            Date createdDate, Date updateDate, boolean isDeleted) {
        this.ID = ID;
        this.catalogID = catalogID;
        this.itemsList = itemsList;
        this.catalogName = catalogName;
        this.description = description;
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
        this.updateDate = (updateDate != null) ? new Date(updateDate.getTime()) : new Date();
        this.isDeleted = isDeleted || false; 
    }

    public boolean getisDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted ;
    }

}
