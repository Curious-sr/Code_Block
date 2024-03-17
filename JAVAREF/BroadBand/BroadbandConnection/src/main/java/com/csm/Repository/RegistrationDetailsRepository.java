package com.csm.Repository;

import com.csm.Model.RegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : BroadbandConnection
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 10/09/2022 - 9:39 AM
 */
public interface RegistrationDetailsRepository extends JpaRepository<RegistrationDetails, Integer> {
	RegistrationDetails getRegistrationDetailsByRegistrationId(int registrationId);
}
