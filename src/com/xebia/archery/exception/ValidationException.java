package com.xebia.archery.exception;

import java.util.HashMap;


// TODO: Auto-generated Javadoc
/**
 * The Class ValidationException.
 */
public class ValidationException extends Exception {

	/** The error map. */
	private HashMap<String, String> errorMap = new HashMap<String, String>();

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new validation exception.
	 */
	public ValidationException() {
		super();
	}
	
	/**
	 * Instantiates a new validation exception.
	 *
	 * @param message the message
	 */
	public ValidationException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public ValidationException(final String message, final Throwable exception) {
		super(message, exception);

	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param exception the exception
	 */
	public ValidationException(final Throwable exception) {
		super(exception);
	}

	/**
	 * Sets the error map.
	 *
	 * @param errorMap the error map
	 */
	public void setErrorMap(HashMap<String, String> errorMap) {
		this.errorMap = errorMap;
	}

	/**
	 * Gets the error map.
	 *
	 * @return the error map
	 */
	public HashMap<String, String> getErrorMap() {
		return errorMap;
	}

}