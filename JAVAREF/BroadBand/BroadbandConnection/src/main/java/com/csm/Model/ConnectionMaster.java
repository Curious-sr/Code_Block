package com.csm.Model;

import javax.persistence.*;

/**
 * @Project : BroadbandConnection
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/09/2022 - 9:32 AM
 */

@Entity
@Table(name = "broadband_connection")
public class ConnectionMaster {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int connectionId;
	private String connectionSpeed;
	@ManyToOne
	@JoinColumn(name = "providerId")
	private ProviderMaster providerMaster;
	private Double fee;

	public int getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}

	public String getConnectionSpeed() {
		return connectionSpeed;
	}

	public void setConnectionSpeed(String connectionSpeed) {
		this.connectionSpeed = connectionSpeed;
	}

	public ProviderMaster getProviderMaster() {
		return providerMaster;
	}

	public void setProviderMaster(ProviderMaster providerMaster) {
		this.providerMaster = providerMaster;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "ConnectionMaster{" +
			   "connectionId=" + connectionId +
			   ", connectionSpeed='" + connectionSpeed + '\'' +
			   ", providerMaster=" + providerMaster +
			   ", fee=" + fee +
			   '}';
	}
}
