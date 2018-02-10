package com.expedia.assignment.business.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -4462829925090848290L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
