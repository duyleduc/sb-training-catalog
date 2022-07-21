package com.example.DemoSpringBoot.models.DTO;

import java.math.BigInteger;
import java.util.Date;

import com.example.DemoSpringBoot.entities.Catalogs;

public class ItemDTO {
    private BigInteger ID;
    private String itemID;
    private String itemName;
    private String description;
    private Catalogs catal0g;
    private Date createdDate, updateDate;
    
    public ItemDTO() {
    }

    
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
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public BigInteger getID() {
        return ID;
    }


    public void setID(BigInteger iD) {
        ID = iD;
    }


    public Date getUpdateDate() {
        return updateDate;
    }


    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public Catalogs getCatal0gs() {
        return catal0g;
    }


    public void setCatal0gs(Catalogs catal0gs) {
        this.catal0g = catal0gs;
    }
}
