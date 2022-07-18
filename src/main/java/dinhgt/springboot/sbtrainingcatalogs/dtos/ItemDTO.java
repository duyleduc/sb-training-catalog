package dinhgt.springboot.sbtrainingcatalogs.dtos;

import java.time.LocalDateTime;

public class ItemDTO {
	private String itemID;

	private String itemName;

	private String description;

	private CatalogDTO catalog;

	private LocalDateTime createdDate;

	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemDTO(String itemID, String itemName, String description,CatalogDTO catalog,
			LocalDateTime createdDate) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;

		this.catalog = catalog;
		this.createdDate = createdDate;
	}

	/**
	 * @return the itemID
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the catalog
	 */
	public CatalogDTO getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog the catalog to set
	 */
	public void setCatalog(CatalogDTO catalog) {
		this.catalog = catalog;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	
	
	
	
}
