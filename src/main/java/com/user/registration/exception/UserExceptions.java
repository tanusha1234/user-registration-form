package com.user.registration.exception;

public class UserExceptions extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public UserExceptions(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public UserExceptions() {
		super();
	}
}