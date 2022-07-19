package com.example.DemoSpringBoot.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
// import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Catalogs {

    @Id
    @Column(name = "catalogid")
    private String catalogID;

    @OneToMany(mappedBy = "catal0g", cascade = {CascadeType.ALL})
    private List<Items> itemsList;

    @Column
    private String catalogName;

    @Column
    private String description;

    @Column
    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;

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

    /**
     * Constructor
     */
    public Catalogs(){}

    public Catalogs(String catalogID,
            String catalogName,
            String description,
            Date createdDate) {
        super();
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.description = description;
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

    public List<Items> getItems() {
        return itemsList;
    }

    public void setItems(List<Items> items) {
        this.itemsList = items;
    }
}
