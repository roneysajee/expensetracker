package com.roney.expensetracker.Exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(CustomResourceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	@ExceptionHandler(ExistingResourceException.class)
	public ResponseEntity<String> handleExsistingResourceException(ExistingResourceException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<String> handleDataAccessException(DataAccessException ex){
		
		if(ex.getCause() instanceof ConstraintViolationException) {
			ConstraintViolationException cause = (ConstraintViolationException) ex.getCause();
			log.error("Class : " + cause.getStackTrace()[0].getClassName() + " : " + cause.getMessage());
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data constraints violated");
		}
		
		log.error("Class : " + ex.getStackTrace()[0].getClassName() + " : " + ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to access data. Try again after some time");
		
	}
	
	//TODO add specific exception handlers here.
	
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> GeneralExceptionHandler(Exception ex){
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Retry the request.If error persist Contact Server admin!!");
//	}
}
