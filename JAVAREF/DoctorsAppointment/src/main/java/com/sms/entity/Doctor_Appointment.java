package com.sms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@Table(name = "doctor_appointment")
public class Doctor_Appointment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctor_Appointment_id;
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="Doctor_id")
	private DoctorMaster doctorMaster;
	private String patient_Name;
	private String patient_Phone;
	private Date date_Of_appointment;
	private Character patient_Status;
}
