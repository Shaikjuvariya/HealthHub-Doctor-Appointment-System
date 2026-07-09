package com.gvp.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvp.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	Optional<Appointment> findByDoctorIdAndPreferredDateAndPreferredTime(
	        Long doctorId,
	        LocalDate preferredDate,
	        LocalTime preferredTime
	    );

}
