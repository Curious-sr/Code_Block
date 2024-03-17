package com.csmtech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="registration_details")
public class RegistrationDetails implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registration_id")
	private Integer registrationId;
	@Column(name="applicant_name")
	private String applicantName;
	@Column(name="email_id")
	private String emailId;
	@Column(name="mobile_no")
	private String mobileNo;
	private String gender;
	private String dob;
	@Column(name="image_path")
	private String imagePath;
	@OneToOne
	@JoinColumn(name="library_id")
	private LibraryMaster library;
	@OneToOne
	@JoinColumn(name="subscription_id")
	private SubscriptionMaster subscription;
}
