package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.csmtech.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

	@Query("From Registration where isDelete='No'")
	List<Registration> getAllRegistraion();

	
	@Transactional
	@Modifying
	@Query("Update Registration set isDelete='Yes' where registrationId=:registrationId")
	void deleteRegistrationById(Integer registrationId);


	@Query("From Registration where club.clubId=:id")
	List<Registration> getAllCollegeByName(Integer id);

}
