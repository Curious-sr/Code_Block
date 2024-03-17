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
	public Registration saveAllBookingDetails(Registration registration) {
		
		return registrationRepository.save(registration);
	}

	@Override
	public List<Registration> getAllBooking() {
		
		return registrationRepository.findAllByIsDelete();
	}

}
