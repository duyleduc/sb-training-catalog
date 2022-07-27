package dinhgt.springboot.sbtrainingcatalogs.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item", schema = "my_schema")
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "item_id")
	private String itemID;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "aid", referencedColumnName = "aid")
	private Catalog catalog;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updated_date;
	
	@Column(name = "is_actived")
	private boolean isActivated;

	@Column(name = "quantity")
	private int quantity;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}




	public Item(int id, String itemID, String itemName, String description, Catalog catalog, LocalDateTime createdDate,
			LocalDateTime updated_date, boolean isActivated, int quantity) {
		super();
		this.id = id;
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
		this.catalog = catalog;
		this.createdDate = createdDate;
		this.updated_date = updated_date;
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
	 * @return the modify_date
	 */
	public LocalDateTime getUpdatedDate() {
		return updated_date;
	}

	/**
	 * @param modify_date the modify_date to set
	 */
	public void setUpdatedDate(LocalDateTime modify_date) {
		this.updated_date = modify_date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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


	/**
	 * @return the updated_date
	 */
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}


	/**
	 * @param updated_date the updated_date to set
	 */
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
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
