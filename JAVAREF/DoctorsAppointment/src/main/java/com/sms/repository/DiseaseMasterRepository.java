package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.entity.DiseaseMaster;
@Repository
public interface DiseaseMasterRepository extends JpaRepository<DiseaseMaster, Integer> {

}
