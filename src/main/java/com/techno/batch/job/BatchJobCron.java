package com.techno.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class BatchJobCron {

	@Autowired
	Job job;

	@Autowired
	JobLauncher jobLauncher;

	@Scheduled(cron = "${batch.processing.schedule}")
	public void empProcessing() throws Exception {
		JobParameters params = new JobParametersBuilder().addString("JobId", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, params);
	}
}
