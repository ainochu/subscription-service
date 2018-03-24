package com.aandres.subscriptionservice.subscription.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.aandres.subscription.gender.model.Gender;

import java.util.Date;

@Entity
@Table(name = "subscription")
public class Subscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "newsletter_id")
	private Long newsletterId;
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;
	@Column(name = "first_name", nullable = true, length = 45)
	private String firstName;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "date_of_birthday", nullable = false)
	private Date dateOfBith;
	@Column(name = "agree", nullable = false)
	private boolean agree;
	@Column(name = "campaign_id", nullable = false)
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
