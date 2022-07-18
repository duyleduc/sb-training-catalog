package dinhgt.springboot.sbtrainingcatalogs.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item", schema = "my_schema")
public class Item {

	@Id
	@Column(name = "item_id")
	private String itemID;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "description")
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "catalog_id")
	private Catalog catalog;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String itemID, String itemName, String description, Catalog catalog, LocalDateTime createdDate) {
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
	 * @return the catalogID
	 */
	public Catalog getCatalog() {
		return catalog;
	}

	/**
	 * @param catalogID the catalogID to set
	 */
	public void setCatalog(Catalog catalog) {
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
