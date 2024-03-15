package com.roney.expensetracker.Exceptions;

public class CustomResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3560705461702713856L;
	private String message;

	public CustomResourceNotFoundException() {
		message = new String("Requested resource not found");
	}

	public CustomResourceNotFoundException(Exception ex) {
		this.message = ex.getMessage();
	}

	public CustomResourceNotFoundException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}

}
