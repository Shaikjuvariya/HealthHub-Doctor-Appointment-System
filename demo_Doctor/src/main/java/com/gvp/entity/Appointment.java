package com.gvp.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // From form
    private String fullName;
    private String email;
    private String phone;

    private Long doctorId;
    private String doctorName;

    private LocalDate preferredDate;
    private LocalTime preferredTime;

    @Column(length = 1000)
    private String notes;

    private String status;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long id, String fullName, String email, String phone, Long doctorId, String doctorName,
			LocalDate preferredDate, LocalTime preferredTime, String notes, String status) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.preferredDate = preferredDate;
		this.preferredTime = preferredTime;
		this.notes = notes;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public LocalDate getPreferredDate() {
		return preferredDate;
	}

	public void setPreferredDate(LocalDate preferredDate) {
		this.preferredDate = preferredDate;
	}

	public LocalTime getPreferredTime() {
		return preferredTime;
	}

	public void setPreferredTime(LocalTime preferredTime) {
		this.preferredTime = preferredTime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ ", doctorId=" + doctorId + ", doctorName=" + doctorName + ", preferredDate=" + preferredDate
				+ ", preferredTime=" + preferredTime + ", notes=" + notes + ", status=" + status + "]";
	}

}
