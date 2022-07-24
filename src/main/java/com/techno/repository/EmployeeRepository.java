package com.techno.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.techno.batch.models.Employee;

@Repository
public interface EmployeeRepository  extends MongoRepository<Employee, String> {

}