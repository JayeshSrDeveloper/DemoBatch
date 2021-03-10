package com.data.transform.batch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.data.transform.dto.HistoryDataDto;
import com.data.transform.entity.HistoryData;

@Configuration
@EnableBatchProcessing
public class DataTransfromBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Value("${filepath}")
	private String filepath;


	@Bean
	public Job dataTransformJob() {
		return  jobBuilderFactory.get("dataTransformJob").incrementer(new RunIdIncrementer()).start(dataTranformStep()).build();

	}

	@Bean
	public Step dataTranformStep() {
		return stepBuilderFactory.get("dataTranformStep").
				<HistoryData,HistoryDataDto>chunk(100).
				reader(dataTransformItemReader()).
				processor(dataTransformItemProcessor()).
				writer(dataTransformItemWriter()).build();
	}

	@Bean
	public DataTransformItemReader  dataTransformItemReader() {
		return new DataTransformItemReader();
	}

	@Bean
	public DataTransformItemProcessor  dataTransformItemProcessor() {
		return new DataTransformItemProcessor();
	}
	@Bean 
	public ItemWriter<HistoryDataDto> dataTransformItemWriter(){
		final ItemWriter<HistoryDataDto> writer = new ItemWriter<HistoryDataDto>() {

			@Override
			public void write(List<? extends HistoryDataDto> items) throws Exception {

				try {
					PrintWriter pw = new PrintWriter(new FileOutputStream(filepath));
					for(HistoryDataDto dto:items) {

						pw.println(dto.toString());
					}
					pw.close();
					//System.out.println("Successfully wrote to the file.");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
		};
		return writer;

	}
}
