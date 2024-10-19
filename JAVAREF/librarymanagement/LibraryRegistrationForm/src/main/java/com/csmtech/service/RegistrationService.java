package com.csmtech.service;

import java.util.List;

import com.csmtech.model.Registration;

public interface RegistrationService {
	Registration saveAllBookingDetails(Registration registration);

	List<Registration> getAllBooking();

}
