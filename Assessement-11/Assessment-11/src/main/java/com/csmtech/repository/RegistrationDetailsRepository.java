package com.csmtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csmtech.model.RegistrationDetails;
@Repository
public interface RegistrationDetailsRepository extends JpaRepository<RegistrationDetails, Integer> {

}
