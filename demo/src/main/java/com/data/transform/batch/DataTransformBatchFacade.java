package com.data.transform.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DataTransformBatchFacade {
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired 
	@Qualifier("dataTransformJob")
	private Job dataTransformJob;

	public void runBatch() {
		final long startTime=System.currentTimeMillis();
		try {
			jobLauncher.run(dataTransformJob, new JobParametersBuilder().addLong("startTime", startTime).toJobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//System.exit(0);
		}
	}
	
}
