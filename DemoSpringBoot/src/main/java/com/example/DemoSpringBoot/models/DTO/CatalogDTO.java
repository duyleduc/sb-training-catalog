package com.example.DemoSpringBoot.models.DTO;

import java.math.BigInteger;
import java.util.Date;

public class CatalogDTO {
    private BigInteger id;

    private String catalogID, catalogName, description;
    private Date createdDate, updateDate;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate != null ? createdDate : new Date();
    }

    public CatalogDTO() {

    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate != null ? createdDate : new Date();
    }

}
