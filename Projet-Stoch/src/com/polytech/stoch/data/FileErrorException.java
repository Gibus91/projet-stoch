package com.polytech.stoch.data;


public class FileErrorException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public FileErrorException(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return message;
	}
}
