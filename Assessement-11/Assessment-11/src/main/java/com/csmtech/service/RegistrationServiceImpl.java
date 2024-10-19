package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.RegistrationDetails;
import com.csmtech.repository.RegistrationDetailsRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDetailsRepository registrationRepository;
	@Override
	public void saveData(RegistrationDetails registrationDetails) {
		registrationRepository.save(registrationDetails);
	}
	@Override
	public List<RegistrationDetails> getAllData() {
		return registrationRepository.findAll();
	}

}
