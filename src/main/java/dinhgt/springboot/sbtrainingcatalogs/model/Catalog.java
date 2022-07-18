package dinhgt.springboot.sbtrainingcatalogs.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalog", schema = "my_schema")
public class Catalog {

	@Id
	@Column(name ="catalog_id")
	private String catalogId;

	@Column(name = "catalog_name")
	private String catalogName;

	@Column(name = "description")
	private String description;

	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	
	
	@OneToMany(mappedBy = "catalog")
	private List<Item> items;

	public Catalog() {
		// TODO Auto-generated constructor stub
	}

	public Catalog(String catalogId, String catalogName, String description, LocalDateTime createdDate,
			List<Item> items) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.description = description;
		this.createdDate = createdDate;
		this.items = items;
	}

	/**
	 * @return the catalogId
	 */
	public String getCatalogId() {
		return catalogId;
	}

	/**
	 * @param catalogId the catalogId to set
	 */
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/**
	 * @return the catalogName
	 */
	public String getCatalogName() {
		return catalogName;
	}

	/**
	 * @param catalogName the catalogName to set
	 */
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
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
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	
}
