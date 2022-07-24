package com.techno.batch.job;

import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.batch.helper.Helper;
import com.techno.batch.models.Employee;
import com.techno.repository.EmployeeRepository;

@Service
public class EmployeeJob implements Tasklet {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("The Job Started");
		List<Employee> employeeList = Helper.excelEmployeeList();
		repository.saveAll(employeeList);
		return RepeatStatus.FINISHED;
	}

}
