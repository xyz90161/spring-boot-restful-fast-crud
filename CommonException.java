package com.fet.expressnote.framework.exception;

public class CommonException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6163793582654628029L;
	private String errorCode;
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
