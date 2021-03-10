package com.data.transform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.data.transform.batch.DataTransformBatchFacade;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired 
	private DataTransformBatchFacade batchfacade;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		batchfacade.runBatch();
	}
}
