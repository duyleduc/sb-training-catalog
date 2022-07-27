package dinhgt.springboot.sbtrainingcatalogs.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalog", schema = "my_schema")
public class Catalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "aid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "catalog_id")
	private String catalogId;

	@Column(name = "catalog_name")
	private String catalogName;

	@Column(name = "description")
	private String description;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "modify_date")
	private LocalDateTime modifyDate;

	@Column(name = "is_actived")
	private boolean isActivated;

	@OneToMany(mappedBy = "catalog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Item> items;

	public Catalog() {
		// TODO Auto-generated constructor stub
	}

	public Catalog(int id, String catalogId, String catalogName, String description, LocalDateTime createdDate,
			LocalDateTime modifyDate, boolean isActivated, List<Item> items) {
		super();
		this.id = id;
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.description = description;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.isActivated = isActivated;
		this.items = items;
	}

	/**
	 * @return the updatedDate
	 */
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
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
