package com.csmtech.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hosuingproperty")
public class HousingProperty implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hid")
	private Long hId;
	
	@Column(name="h_name")
	private String hName;
	
	@Column(name="h_cost")
	private Double hCost;
	
	 @ManyToOne(cascade= CascadeType.ALL)
	 @JoinColumn(name="hpid")
	 private HousingProject housingProject;
	

	public Long gethId() {
		return hId;
	}

	public void sethId(Long hId) {
		this.hId = hId;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public Double gethCost() {
		return hCost;
	}

	public void sethCost(Double hCost) {
		this.hCost = hCost;
	}

	public HousingProject getHousingProject() {
		return housingProject;
	}

	public void setHousingProject(HousingProject housingProject) {
		this.housingProject = housingProject;
	}

	@Override
	public String toString() {
		return "HousingProperty [hId=" + hId + ", hName=" + hName + ", hCost=" + hCost + ", housingProject="
				+ housingProject + "]";
	}

	
	 
	 
	
}
