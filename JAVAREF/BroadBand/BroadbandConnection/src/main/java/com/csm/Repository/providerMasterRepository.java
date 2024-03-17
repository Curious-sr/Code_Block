package com.csm.Repository;

import com.csm.Model.ProviderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : BroadbandConnection
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/09/2022 - 9:29 AM
 */
public interface providerMasterRepository extends JpaRepository<ProviderMaster, Integer> {
	ProviderMaster getProviderMasterByProviderId(int providerId);
}
