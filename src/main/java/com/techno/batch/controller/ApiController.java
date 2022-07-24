package com.techno.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.service.EmployeeService;

@RestController
public class ApiController {

	@Autowired
	public EmployeeService service;

	@GetMapping("/api/employee")
	public ResponseEntity<String> saveEmployeeAPI() {
		service.saveEmployeeData();
		return new ResponseEntity<String>("Employee Data Loaded SuccessFully", HttpStatus.OK);
	}
}
