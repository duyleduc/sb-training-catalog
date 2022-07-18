package dinhgt.springboot.sbtrainingcatalogs.exception.item;

public class ItemCreateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemCreateException(String message, Throwable cause) {
		super(message, cause);

	}

	public ItemCreateException(String message) {
		super(message);

	}

	public ItemCreateException(Throwable cause) {
		super(cause);

	}
}
