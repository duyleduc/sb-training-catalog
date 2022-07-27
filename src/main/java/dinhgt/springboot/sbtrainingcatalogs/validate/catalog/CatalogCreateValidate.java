package dinhgt.springboot.sbtrainingcatalogs.validate.catalog;

import dinhgt.springboot.sbtrainingcatalogs.dtos.CatalogDTO;
import dinhgt.springboot.sbtrainingcatalogs.exception.catalog.CatalogCreateException;

public class CatalogCreateValidate {

	public static void validate(CatalogDTO catalog) {
		
		if(catalog.getCatalogName().isEmpty()) {
			throw new CatalogCreateException("Catalog Name cannot be empty!");
		}
		if(catalog.getCatalogId().isEmpty()) {
			throw new CatalogCreateException("Catalog ID cannot be empty!");
		}
		
	}
}
