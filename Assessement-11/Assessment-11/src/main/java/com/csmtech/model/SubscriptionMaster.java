package com.csmtech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="subscription_master")
public class SubscriptionMaster implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subscription_id")
	private Integer subscriptionId;
	@Column(name="subscription_type")
	private String subscriptionType;
	@Column(name="library_id")
	private Integer libraryId;
	private Double fees;
}
