package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csmtech.model.HousingProperty;

public interface HousingPropertyRepository extends JpaRepository<HousingProperty, Long> {
	
	@Query("From HousingProperty where housingProject.hpId=:pId")
	List<HousingProperty> allPropertyList(Long pId);
	
	@Query("select hCost From HousingProperty where hId=:cId")
	Double getCostByCid(Long cId);

}
