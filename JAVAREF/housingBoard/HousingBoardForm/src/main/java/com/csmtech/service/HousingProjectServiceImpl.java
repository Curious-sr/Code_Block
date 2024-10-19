package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.HousingProject;
import com.csmtech.repository.HousingProjectRepository;

@Service
public class HousingProjectServiceImpl implements HousingProjectService {

	@Autowired
	private HousingProjectRepository housingProjectRepository;

	@Override
	public List<HousingProject> getAllProjects() {
		
		return housingProjectRepository.findAll();
	}
	
	
	

}
