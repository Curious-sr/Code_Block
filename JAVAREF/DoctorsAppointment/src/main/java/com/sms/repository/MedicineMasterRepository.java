package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.entity.MedicineMaster;
@Repository
public interface MedicineMasterRepository extends JpaRepository<MedicineMaster, Integer> {
	@Query("From MedicineMaster Where diseaseMaster.disease_id=:diseaseId")
	List<MedicineMaster> getAllMedicinesByDiseaseId(Integer diseaseId);

}
