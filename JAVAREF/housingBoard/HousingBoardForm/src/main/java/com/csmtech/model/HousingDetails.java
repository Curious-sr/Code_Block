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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="housingdetails")
public class HousingDetails implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hdid")
	private Long hdId;
	
	@Column(name="applicant_name")
	private String applicantName;
	
	private String email;
	
	@Column(name="mobile_no")
	private Long mobileNo;
	
	private Date dob;

	private String gender;
	
	private Long age;
	
	@Column(name="id_proof")
	private String idProof;
	

	  @Column(name="is_delete")
	  private String isDelete;
	  
	  
	  @OneToOne
	  @JoinColumn(name="hid")
	  private HousingProperty housingProperty;
	

	public Long getHdId() {
		return hdId;
	}

	public void setHdId(Long hdId) {
		this.hdId = hdId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	/*
	 * public HousingProperty getHousingProperty() { return housingProperty; }
	 * 
	 * public void setHousingProperty(HousingProperty housingProperty) {
	 * this.housingProperty = housingProperty; }
	 */	
	

	public Long getAge() {
		return age;
	}
	
	public void setAge(Long age) {
		this.age = age;
	}

	public HousingProperty getHousingProperty() {
		return housingProperty;
	}

	public void setHousingProperty(HousingProperty housingProperty) {
		this.housingProperty = housingProperty;
	}

	@Override
	public String toString() {
		return "HousingDetails [hdId=" + hdId + ", applicantName=" + applicantName + ", email=" + email + ", mobileNo="
				+ mobileNo + ", dob=" + dob + ", gender=" + gender + ", age=" + age + ", idProof=" + idProof
				+ ", isDelete=" + isDelete + ", housingProperty=" + housingProperty + "]";
	}

	

	

	

	

	
	
}
