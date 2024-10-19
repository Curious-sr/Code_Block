package com.csmtech.service;

import java.util.List;

import com.csmtech.model.HousingProperty;

public interface HousingPropertyService {

	List<HousingProperty> allPropertyList(Long pId);

	Double getCostByCid(Long cId);

	
}
