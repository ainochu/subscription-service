package com.aandres.subscriptionservice.common.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

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
