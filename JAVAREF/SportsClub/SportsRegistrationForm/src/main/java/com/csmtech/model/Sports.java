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

@Table(name="sports_master")
@Entity
public class Sports implements Serializable {

	@Id
	@Column(name="sports_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sportsId;
	
	@Column(name="sports_name")
	private String sportsName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="club_id")
	private Club club;
	
	private Double fees;

	public Integer getSportsId() {
		return sportsId;
	}

	public void setSportsId(Integer sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Sports [sportsId=" + sportsId + ", sportsName=" + sportsName + ", club=" + club + ", fees=" + fees
				+ "]";
	}
	
	
	
}
