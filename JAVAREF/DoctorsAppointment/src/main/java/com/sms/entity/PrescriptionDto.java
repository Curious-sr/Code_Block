package com.sms.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class PrescriptionDto implements Serializable {
	private Integer doctorId;
	private Integer patientId;
	private Integer diseaseId;
	private Integer medicineId;
	private String prescription;
	
}
