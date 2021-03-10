package com.data.transform.batch;

import java.util.Iterator;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.data.transform.entity.HistoryData;
import com.data.transform.repository.HistoryDataRepository;

public class DataTransformItemReader implements ItemReader<HistoryData> {
	@Autowired 
	private HistoryDataRepository repository;

	private Iterator<HistoryData> iterator;

	@BeforeStep
	public void before(final StepExecution stepExecution) {
		iterator=repository.findAll().iterator();
	}
	@Override
	public HistoryData read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(iterator!=null && iterator.hasNext()) {
			return iterator.next();
		}else {
			return null;
		}
	}

}
