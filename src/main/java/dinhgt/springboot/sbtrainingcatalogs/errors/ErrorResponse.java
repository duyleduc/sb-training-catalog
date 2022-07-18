package dinhgt.springboot.sbtrainingcatalogs.errors;

public class ErrorResponse {

	private int httpCode;
	private String message;
	private long timestamp;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(int httpCode, String message, long timestamp) {
		super();
		this.httpCode = httpCode;
		this.message = message;
		this.timestamp = timestamp;
	}

	/**
	 * @return the httpCode
	 */
	public int getHttpCode() {
		return httpCode;
	}

	/**
	 * @param httpCode the httpCode to set
	 */
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
