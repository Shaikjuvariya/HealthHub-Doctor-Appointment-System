package com.gvp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctors")

public class Doctor {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String specialization;
	    private String email;
	    private String phone;
		public Doctor() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Doctor(Long id, String name, String specialization, String email, String phone) {
			super();
			this.id = id;
			this.name = name;
			this.specialization = specialization;
			this.email = email;
			this.phone = phone;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
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
		@Override
		public String toString() {
			return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", email=" + email
					+ ", phone=" + phone + "]";
		}

}
