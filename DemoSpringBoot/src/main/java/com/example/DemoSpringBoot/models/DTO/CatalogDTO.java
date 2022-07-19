package com.example.DemoSpringBoot.models.DTO;

import java.util.Date;

public class CatalogDTO {
    private String catalogID, catalogName, description;
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
        this.createdDate = createdDate;
    }

    public CatalogDTO(){
        
    }
}
