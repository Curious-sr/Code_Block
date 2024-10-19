package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Registration;
import com.csmtech.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public Registration saveAllRegistrationDetails(Registration registration) {
		
		return registrationRepository.save(registration);
	}

	@Override
	public List<Registration> getAllRegistration() {
		
		return registrationRepository.getAllRegistraion();
	}

	@Override
	public void deleteRegistrationById(Integer registrationId) {
		
		registrationRepository.deleteRegistrationById(registrationId);
	}

	@Override
	public Registration updateRegistrationById(Integer registrationId) {
		
		return registrationRepository.findById(registrationId).get();
	}

	@Override
	public List<Registration> getAllCollegeByName(Integer id) {
		
		return registrationRepository.getAllCollegeByName(id);
	}

}
