package com.zensar.exceptions;

public class InvalidStockIdException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public InvalidStockIdException(String message) {
		super(message);
	}
}
