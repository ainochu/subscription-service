package com.aandres.subscriptionservice.common.model.dto;

import org.springframework.http.HttpStatus;

public enum ResponseCode {
	

	// Application Exceptions
	SUBSCRIPTION_EXCEPTION(HttpStatus.BAD_REQUEST, 1, "Error to create a new subscription"),
	SERVICE_EMAIL_EXCEPTION(HttpStatus.BAD_REQUEST, 2, "Error to connect with email service"),
	EMAIL_EXISTS(HttpStatus.BAD_REQUEST, 3, "The email already exists"),
	SERVICE_EVENT_EXCEPTION(HttpStatus.BAD_REQUEST, 4, "Error to connect with event service"),
	SUBSCRIPTION_AGREE_EXCEPTION(HttpStatus.BAD_REQUEST, 5, "The user must be agree ");
	
	private final HttpStatus httpStatus;
	private final int code;

	private final String description;

	private ResponseCode(HttpStatus httpStatus, int code, String description) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.description = description;
	}

	public int value() {
		return this.code;
	}

	@Override
	public String toString() {
		return Integer.toString(this.code);
	}

	public static ResponseCode valueOf(int statusCode) {
		for (ResponseCode status : values()) {
			if (status.code == statusCode) {
				return status;
			}
		}
		throw new IllegalArgumentException("No matches for [" + statusCode + "]");
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}


}
