package com.sms.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.entity.Doctor_Appointment;
@Repository
public interface Doctor_AppointmentRepository extends JpaRepository<Doctor_Appointment, Integer> {
	
	@Query("From Doctor_Appointment where doctorMaster.Doctor_id=:doctorIdd AND patient_Status = 'A' AND date_Of_appointment = CURDATE()")
	List<Doctor_Appointment> findPatientDetailsById(Integer doctorIdd);
	
	@Query("From Doctor_Appointment where Doctor_Appointment_id=:doctorsAppointmentId")
	Doctor_Appointment getPatientDetailsByPatientId(Integer doctorsAppointmentId);
	
	@Query("From Doctor_Appointment where doctorMaster.Doctor_id=:doctorId AND patient_Status = 'A' AND date_Of_appointment = CURDATE()")
	List<Doctor_Appointment> getPatientDetailsByDoctorId(Integer doctorId);

}
