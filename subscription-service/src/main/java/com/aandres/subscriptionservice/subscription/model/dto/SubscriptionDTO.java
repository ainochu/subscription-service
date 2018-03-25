package com.aandres.subscriptionservice.subscription.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.aandres.subscription.gender.model.Gender;
import com.aandres.subscriptionservice.common.constant.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SubscriptionDTO {
	
	
	private Long newsletterId;
	@NotNull
	private String email;
	@NotNull
	private String firstName;
	private Gender gender;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FORMAT_TIMEZONE)
	@NotNull
	private Date dateOfBirth;
	private boolean agree;
	private Long campaignId;
	
	public Long getNewsletterId() {
		return newsletterId;
	}
	public void setNewsletterId(Long newsletterId) {
		this.newsletterId = newsletterId;
	}
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
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
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
	public Long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}
	@Override
	public String toString() {
		return "SubscriptionDTO [newsletterId=" + newsletterId + ", email=" + email + ", firstName=" + firstName
				+ ", gender=" + gender + ", dateOfBith=" + dateOfBirth + ", agree=" + agree + ", campaignId="
				+ campaignId + "]";
	}
	
	
	
	
	

}
