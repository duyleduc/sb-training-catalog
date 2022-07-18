package dinhgt.springboot.sbtrainingcatalogs.exception.catalog;

public class CatalogCreateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CatalogCreateException(String message, Throwable cause) {
		super(message, cause);

	}

	public CatalogCreateException(String message) {
		super(message);

	}

	public CatalogCreateException(Throwable cause) {
		super(cause);

	}
}
