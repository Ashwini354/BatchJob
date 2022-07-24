package com.techno.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchJobConfig {
	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Autowired
	private EmployeeJob employeeJob;

	@Value("${batch.processing.jobname}")
	private String jobName;

	@Bean
	public Step createStep() {
		return steps.get("employeeBatchStep").tasklet(employeeJob).build();
	}

	@Bean
	public Job employeeProcessingJob() {
		return jobs.get(jobName).incrementer(new RunIdIncrementer()).start(createStep()).build();

	}
}
