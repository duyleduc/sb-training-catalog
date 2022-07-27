package dinhgt.springboot.sbtrainingcatalogs.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CatalogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int id;

	private String catalogId;

	private String catalogName;

	private String description;

	private LocalDateTime createdDate;

	private LocalDateTime modifyDate;

	private boolean isActivated;

	public CatalogDTO() {
		// TODO Auto-generated constructor stub
	}

	public CatalogDTO(int id, String catalogId, String catalogName, String description, LocalDateTime createdDate,
			LocalDateTime modifyDate, boolean isActivated) {
		super();
		this.id = id;
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.description = description;
		this.createdDate = createdDate;
		this.modifyDate = modifyDate;
		this.isActivated = isActivated;
	}

	/**
	 * @return the modifyDate
	 */
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate the modifyDate to set
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

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

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
