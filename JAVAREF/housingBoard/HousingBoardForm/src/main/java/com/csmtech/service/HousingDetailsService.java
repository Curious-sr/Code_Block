package com.csmtech.service;

import java.util.List;

import com.csmtech.model.HousingDetails;

public interface HousingDetailsService {

	HousingDetails saveAllBookingDetails(HousingDetails housingDetails);

	List<HousingDetails> getAllBooking();

	void deleteBookingById(Long hdId);

}
