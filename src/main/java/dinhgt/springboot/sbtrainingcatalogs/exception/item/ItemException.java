package dinhgt.springboot.sbtrainingcatalogs.exception.item;

public class ItemException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemException(String message, Throwable cause) {
		super(message, cause);

	}

	public ItemException(String message) {
		super(message);

	}

	public ItemException(Throwable cause) {
		super(cause);

	}
}
