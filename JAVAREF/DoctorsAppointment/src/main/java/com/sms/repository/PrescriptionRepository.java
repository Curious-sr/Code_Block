package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
	@Query("From Prescription Where doctor_Appointment.doctor_Appointment_id=:pId")
	Prescription findByDoctorAppointmentId(Integer pId);

	@Query("From Prescription Where doctor_Appointment.doctorMaster.Doctor_id=:doctorId")
	List<Prescription> getPresicriptionByDoctorId(Integer doctorId);

}
