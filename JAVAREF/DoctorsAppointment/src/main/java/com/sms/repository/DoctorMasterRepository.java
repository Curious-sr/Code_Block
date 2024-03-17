package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entity.DoctorMaster;
@Repository
public interface DoctorMasterRepository extends JpaRepository<DoctorMaster, Integer> {

}
