package dinhgt.springboot.sbtrainingcatalogs.exception.item;

public class ItemUpdateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemUpdateException(String message, Throwable cause) {
		super(message, cause);

	}

	public ItemUpdateException(String message) {
		super(message);

	}

	public ItemUpdateException(Throwable cause) {
		super(cause);

	}
}
