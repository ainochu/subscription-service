package com.aandres.subscriptionservice.register.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.aandres.subscriptionservice.common.constant.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class RegisterDTO {
	
	@NotNull
	@NotEmpty
	@ApiModelProperty(notes = "User email", required = true)
	private String email;
	@ApiModelProperty(notes = "User first name", required = false)
	private String firstName;
	@ApiModelProperty(notes = "User gender. Only FEMALE or MALE", required = false)
	private String gender;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FORMAT_TIMEZONE)
	@ApiModelProperty(notes = "User birthday", required =true)
	private Date dateOfBirth;
	@NotNull
	@ApiModelProperty(notes = "Consent user", required =true)
	private boolean agree;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isAgree() {
		return agree;
	}
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	@Override
	public String toString() {
		return "RegisterDTO [email=" + email + ", firstName=" + firstName + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", agree=" + agree + "]";
	}
	
	
	
	
	
	

}
