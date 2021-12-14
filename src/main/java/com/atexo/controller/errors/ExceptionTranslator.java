package com.atexo.controller.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.atexo.controller.errors.domain.ErrorResponse;

/**
 * la classe permet de gerer les exception du controlleur 
 * 
 * @author Mohammed BENALI
 *
 */
@ControllerAdvice
public class ExceptionTranslator{
	/**
	 * 
	 * @param exception
	 * @return ResponseEntity avec le message d'erreur et le code erreur
	 */
	@ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(RuntimeException exception) {
		ErrorResponse response = new ErrorResponse(exception.getMessage());
        
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}