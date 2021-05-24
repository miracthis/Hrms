package com.hrms.hrms.core.utilities.customize;

public class ValidationError {

	private boolean success;
	private String message;
	private String details;
	
	public ValidationError(boolean success, String message, String details) {
		super();
		this.success = success;
		this.message = message;
		this.details = details;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
