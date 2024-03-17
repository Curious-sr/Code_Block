package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Sports;
import com.csmtech.repository.SportsRepository;

@Service
public class SportsServiceImpl implements SportsService {

	@Autowired
	private SportsRepository sportsRepository;
	
	@Override
	public List<Sports> allSportsList(Integer clubId) {
		
		return sportsRepository.allSportsList(clubId);
	}

}
