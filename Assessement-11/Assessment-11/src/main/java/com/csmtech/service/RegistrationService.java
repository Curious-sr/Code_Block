package com.csmtech.service;

import java.util.List;

import com.csmtech.model.RegistrationDetails;

public interface RegistrationService {

	void saveData(RegistrationDetails registrationDetails);

	List<RegistrationDetails> getAllData();

}
