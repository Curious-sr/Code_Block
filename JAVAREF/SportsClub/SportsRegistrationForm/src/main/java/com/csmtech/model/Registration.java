package com.csmtech.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="registration_details")
@Entity
public class Registration implements Serializable{

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
	
	private Date dob;
	
	@Column(name="image_path")
	private String imagePath;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="club_id")
	private Club club;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="sports_id")
	private Sports sports;
	
	@Column(name="is_delete")
	private String isDelete;

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Registration [registrationId=" + registrationId + ", applicantName=" + applicantName + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", gender=" + gender + ", dob=" + dob + ", imagePath="
				+ imagePath + ", club=" + club + ", sports=" + sports + ", isDelete=" + isDelete + "]";
	}
	
	
}
