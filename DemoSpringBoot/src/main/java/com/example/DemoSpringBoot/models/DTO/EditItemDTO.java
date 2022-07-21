package com.example.DemoSpringBoot.models.DTO;


public class EditItemDTO {
    private String itemID;
    private String itemName;
    private String description;
    private String CatalogID;

    

    public EditItemDTO() {
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
    public String getCatalogID() {
        return CatalogID;
    }
    public void setCatalogID(String catalogID) {
        CatalogID = catalogID;
    }

    
}
