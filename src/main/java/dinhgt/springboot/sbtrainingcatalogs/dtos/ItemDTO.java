package dinhgt.springboot.sbtrainingcatalogs.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String itemID;

	private String itemName;

	private String description;

	private CatalogDTO catalog;

	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;

	private boolean isActivated;
 
	private int quantity;
	
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public ItemDTO(int id, String itemID, String itemName, String description, CatalogDTO catalog,
			LocalDateTime createdDate, LocalDateTime updatedDate, boolean isActivated, int quantity) {
		super();
		this.id = id;
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
		this.catalog = catalog;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.isActivated = isActivated;
		this.quantity = quantity;
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	/**
	 * @return the updatedDate
	 */
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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

	/**
	 * @return the isActivated
	 */
	public boolean isActivated() {
		return isActivated;
	}

	/**
	 * @param isActivated the isActivated to set
	 */
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

}
