package com.roney.expensetracker.Exceptions;

public class ExistingResourceException extends RuntimeException{

	private static final long serialVersionUID = -3488298109345912338L;

	private String message;

	public ExistingResourceException() {
		this.message = "The resource already exists. Connot be created";
	}

	public String getMessage() {
		return message;
	}
}
