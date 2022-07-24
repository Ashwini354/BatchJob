package com.techno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techno.batch.helper.Helper;
import com.techno.batch.models.Employee;
import com.techno.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public void saveEmployeeData() {

		List<Employee> employeeList = Helper.excelEmployeeList();
		repository.saveAll(employeeList);
	}

}
