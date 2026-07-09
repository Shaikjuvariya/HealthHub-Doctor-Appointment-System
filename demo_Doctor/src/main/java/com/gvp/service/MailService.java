package com.gvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gvp.entity.Appointment;

@Service
public class MailService {
	    @Autowired
	    private JavaMailSender mailSender;

	    public void sendBookingMail(Appointment appt) {

	        SimpleMailMessage msg = new SimpleMailMessage();

	        msg.setTo(appt.getEmail());
	        msg.setSubject("Doctor Appointment Confirmation");

	        msg.setText(
	            "Hello " + appt.getFullName() + ",\n\n" +
	            "Your appointment has been booked successfully.\n\n" +

	            "Patient Name: " + appt.getFullName() + "\n" +
	            "Doctor Name: " + appt.getDoctorName() + "\n" +
	            "Phone: " + appt.getPhone() + "\n" +
	            "Date: " + appt.getPreferredDate() + "\n" +
	            "Time: " + appt.getPreferredTime() + "\n\n" +

	            "Thank you,\nHealthCare Team"
	        );

	        mailSender.send(msg);
	    }
	}


