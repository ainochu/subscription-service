package com.aandres.subscriptionservice.common.model.dto;

public class ErrorResultDTO {

	private String description;

	public ErrorResultDTO(ResponseCode responseCode) {
		this.description = responseCode.getDescription();
	}

	public ErrorResultDTO(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "ErrorResultDTO [description=" + description + "]";
	}

	

}
