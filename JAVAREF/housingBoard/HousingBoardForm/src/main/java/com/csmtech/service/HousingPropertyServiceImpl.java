package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.HousingProperty;
import com.csmtech.repository.HousingPropertyRepository;

@Service
public class HousingPropertyServiceImpl implements HousingPropertyService {

	@Autowired
	private HousingPropertyRepository housingPropertyRepository;
	 
	@Override
	public List<HousingProperty> allPropertyList(Long pId) {
		
		return housingPropertyRepository.allPropertyList(pId);
	}

	@Override
	public Double getCostByCid(Long cId) {
		
		return housingPropertyRepository.getCostByCid(cId);
	}

}
