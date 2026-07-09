package com.gvp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvp.entity.User;
import com.gvp.service.Userservice;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {
	  @Autowired
	    private Userservice service;

	    @PostMapping("/register")
	    public User register(@RequestBody User user) {
	        return service.register(user);
	    }

	    @PostMapping("/login")
	    public Object login(@RequestBody User user) {

	        Optional<User> u = service.login(user.getEmail(), user.getPassword());

	        if(u.isPresent())
	            return u.get();

	        return "Invalid credentials";
	    }

}
