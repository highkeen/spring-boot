package com.highken.training.bootlearn.exception;

import lombok.Getter;

@Getter
public class HighkeenBootLearnException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

	/**
	 * 
	 */

	public HighkeenBootLearnException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HighkeenBootLearnException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HighkeenBootLearnException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HighkeenBootLearnException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HighkeenBootLearnException(String erroCode, String errorMessage) {
		super(String.join(",", erroCode, errorMessage));
		this.errorCode = erroCode;
		this.errorMessage = errorMessage;
	}
}
