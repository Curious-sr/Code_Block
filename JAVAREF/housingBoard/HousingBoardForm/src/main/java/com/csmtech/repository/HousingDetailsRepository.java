package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.csmtech.model.HousingDetails;

public interface HousingDetailsRepository extends JpaRepository<HousingDetails, Long> {

	
	@Query("From HousingDetails where isDelete='No'")
	List<HousingDetails> findAllByIsDelete();
	
	@Transactional
	@Modifying
	@Query("Update HousingDetails set isDelete='Yes' where hdId=:hdId")
	void deleteBookingById(@Param("hdId")Long hdId);
	

}
