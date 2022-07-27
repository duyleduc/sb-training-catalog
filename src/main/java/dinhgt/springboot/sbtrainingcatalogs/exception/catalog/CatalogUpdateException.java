package dinhgt.springboot.sbtrainingcatalogs.exception.catalog;

public class CatalogUpdateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogUpdateException(String message, Throwable cause) {
		super(message, cause);

	}

	public CatalogUpdateException(String message) {
		super(message);

	}

	public CatalogUpdateException(Throwable cause) {
		super(cause);

	}
}
