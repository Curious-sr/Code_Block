package com.csm.Model;



import javax.persistence.*;
import java.sql.Date;

/**
 * @Project : BroadbandConnection
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/09/2022 - 9:34 AM
 */
@Entity
@Table(name = "registration_details")
public class RegistrationDetails {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registrationId;
	private String applicantName;
	private String mailId;
	private String mobileNumber;
	private String gender;
	private Date dateOfBirth;
	private String imagePath;
	private String imageName;
	private int age;
	@ManyToOne
	@JoinColumn(name = "providerId")
	private ProviderMaster providerMaster;
	@ManyToOne
	@JoinColumn(name = "connectionId")
	private ConnectionMaster connectionMaster;

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ProviderMaster getProviderMaster() {
		return providerMaster;
	}

	public void setProviderMaster(ProviderMaster providerMaster) {
		this.providerMaster = providerMaster;
	}

	public ConnectionMaster getConnectionMaster() {
		return connectionMaster;
	}

	public void setConnectionMaster(ConnectionMaster connectionMaster) {
		this.connectionMaster = connectionMaster;
	}

	@Override
	public String toString() {
		return "RegistrationDetails{" +
			   "registrationId=" + registrationId +
			   ", applicantName='" + applicantName + '\'' +
			   ", mailId='" + mailId + '\'' +
			   ", mobileNumber='" + mobileNumber + '\'' +
			   ", gender='" + gender + '\'' +
			   ", dateOfBirth=" + dateOfBirth +
			   ", imagePath='" + imagePath + '\'' +
			   ", imageName='" + imageName + '\'' +
			   ", age=" + age +
			   ", providerMaster=" + providerMaster +
			   ", connectionMaster=" + connectionMaster +
			   '}';
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
