package com.csmtech.service;

import java.util.List;

import com.csmtech.model.Registration;

public interface RegistrationService {

	Registration saveAllRegistrationDetails(Registration registration);

	List<Registration> getAllRegistration();

	void deleteRegistrationById(Integer registrationId);

	Registration updateRegistrationById(Integer registrationId);

	List<Registration> getAllCollegeByName(Integer id);
	
	

}
