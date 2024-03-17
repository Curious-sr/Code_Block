package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.HousingDetails;
import com.csmtech.repository.HousingDetailsRepository;

@Service
public class HousingDetailsServiceImpl implements HousingDetailsService {

	@Autowired
	private HousingDetailsRepository housingDetailsRepository;

	@Override
	public HousingDetails saveAllBookingDetails(HousingDetails housingDetails) {
		
		return housingDetailsRepository.save(housingDetails);
	}

	@Override
	public List<HousingDetails> getAllBooking() {
		
		return housingDetailsRepository.findAllByIsDelete();
	}

	@Override
	public void deleteBookingById(Long hdId) {
		
		housingDetailsRepository.deleteBookingById(hdId);
	}
	
	

}
