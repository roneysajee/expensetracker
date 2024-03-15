package com.roney.expensetracker.Exceptions;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 7112286210561540916L;
	private String message;

	public InvalidInputException() {
		message = "Invalid input";
	}
	
	public InvalidInputException(String msg) {
		this.message = msg;
	}

	public InvalidInputException(Object obj) {
		this();
		message += obj.toString();
	}

	public String getMessage() {
		return message;
	}

}
