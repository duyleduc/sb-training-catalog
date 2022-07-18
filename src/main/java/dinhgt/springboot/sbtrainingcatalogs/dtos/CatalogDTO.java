package dinhgt.springboot.sbtrainingcatalogs.dtos;

import java.time.LocalDateTime;

public class CatalogDTO {

	private String catalogId;

	private String catalogName;

	private String description;

	private LocalDateTime createdDate;

	public CatalogDTO() {
		// TODO Auto-generated constructor stub
	}

	public CatalogDTO(String catalogId, String catalogName, String desciption, LocalDateTime createdDate) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.description = desciption;
		this.createdDate = createdDate;
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

}
