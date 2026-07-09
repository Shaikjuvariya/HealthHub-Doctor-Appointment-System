package com.gvp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gvp.Repository.AppointmentRepository;
import com.gvp.entity.Appointment;

@Service
public class AppointmentService {
	    @Autowired
	    private AppointmentRepository repo;
	    @Autowired
	    private MailService mailSender;


	    public String bookAppointment(Appointment appointment) {

	        Optional<Appointment> existing =
	            repo.findByDoctorIdAndPreferredDateAndPreferredTime(
	                appointment.getDoctorId(),
	                appointment.getPreferredDate(),
	                appointment.getPreferredTime()
	            );

	        if(existing.isPresent()) {
	            return "Slot already booked!";
	        }

	        appointment.setStatus("BOOKED");
	        repo.save(appointment);
	     

	        mailSender.sendBookingMail(appointment);


	        return "Appointment booked successfully";
	    }

	    public List<Appointment> getAllAppointments() {
	        return repo.findAll();
	    }

	    public String cancelAppointment(Long id) {
	        Optional<Appointment> appt = repo.findById(id);

	        if(appt.isPresent()) {
	            Appointment a = appt.get();
	            a.setStatus("CANCELLED");
	            repo.save(a);
	            return "Cancelled";
	        }

	        return "Not found";
	    }

	}