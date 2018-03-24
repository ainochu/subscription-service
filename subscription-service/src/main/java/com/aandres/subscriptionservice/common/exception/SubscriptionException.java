package com.aandres.subscriptionservice.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aandres.subscriptionservice.common.model.dto.ErrorResultDTO;
import com.aandres.subscriptionservice.common.model.dto.ResponseCode;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SubscriptionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final transient ErrorResultDTO errorResultDTO;
	
	public SubscriptionException(ResponseCode responseCode) {
		super(responseCode.getDescription());
		this.errorResultDTO = new ErrorResultDTO(responseCode);
	}

	public ErrorResultDTO getErrorResultDTO() {
		return errorResultDTO;
	}
	
	

}
