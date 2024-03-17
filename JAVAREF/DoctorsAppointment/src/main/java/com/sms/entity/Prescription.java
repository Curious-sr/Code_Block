package com.sms.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "prescription")
public class Prescription implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slno;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Doctor_Appointment_id")
	private Doctor_Appointment doctor_Appointment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="disease_id")
	private DiseaseMaster diseaseMaster;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="medicine_id")
	private MedicineMaster medicineMaster;
	private String prescription;
}
