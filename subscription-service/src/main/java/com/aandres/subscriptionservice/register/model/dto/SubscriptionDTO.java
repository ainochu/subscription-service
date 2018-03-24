package com.aandres.subscriptionservice.register.model.dto;

import java.util.Date;

import com.aandres.subscriptionservice.common.constant.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SubscriptionDTO {
	
	private Long newsletterId;
	private String email;
	private String firstName;
	private String gender;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.FORMAT_TIMEZONE)
	private Date dateOfBith;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBith() {
		return dateOfBith;
	}
	public void setDateOfBith(Date dateOfBith) {
		this.dateOfBith = dateOfBith;
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
				+ ", gender=" + gender + ", dateOfBith=" + dateOfBith + ", agree=" + agree + ", campaignId="
				+ campaignId + "]";
	}
	
	
	
	
	

}
