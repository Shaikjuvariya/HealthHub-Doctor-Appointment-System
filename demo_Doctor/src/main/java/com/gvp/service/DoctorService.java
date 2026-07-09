package com.gvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvp.Repository.DoctorRepository;
import com.gvp.entity.Doctor;

@Service
public class DoctorService {
	@Autowired
    private DoctorRepository repo;

    public Doctor saveDoctor(Doctor doctor) {
        return repo.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return repo.findAll();
    }

}
