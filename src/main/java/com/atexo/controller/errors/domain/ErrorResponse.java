package com.atexo.controller.errors.domain;

/**
 * 
 * @author Mohammed BENALI
 *
 */
public class ErrorResponse {

	/**
	 * 
	 */
	private String message;

	/**
	 * constructeur de la reponse d'erreur
	 * 
	 * @param message d'erreur
	 */
	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	/**
	 * 
	 * @return message d'erreur
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message d'erreur
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
