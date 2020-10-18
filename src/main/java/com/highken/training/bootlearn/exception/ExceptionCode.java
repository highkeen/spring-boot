package com.highken.training.bootlearn.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

	NOT_FOUND("E-001","Not found");

	private String errorCode;
	private String message;
	ExceptionCode(String errorCode, String message) {
		this.errorCode=errorCode;
		this.message=message;
	}
}
