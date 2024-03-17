package com.csm.Model;

import javax.persistence.*;

/**
 * @Project : BroadbandConnection
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/09/2022 - 9:26 AM
 */

@Entity
@Table(name = "provider_master")
public class ProviderMaster {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int providerId;
	private String providerName;

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public String toString() {
		return "ProviderMaster{" +
			   "providerId=" + providerId +
			   ", providerName='" + providerName + '\'' +
			   '}';
	}
}
