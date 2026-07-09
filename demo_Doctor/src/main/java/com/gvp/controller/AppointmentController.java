package com.gvp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvp.entity.Appointment;
import com.gvp.service.AppointmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/appointments")
public class AppointmentController {
	@Autowired
    private AppointmentService service;

    @PostMapping("/book")
    public String book(@RequestBody Appointment appointment) {
        return service.bookAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAllAppointments();
    }

    @PutMapping("/cancel/{id}")
    public String cancel(@PathVariable Long id) {
        return service.cancelAppointment(id);
    }

}
