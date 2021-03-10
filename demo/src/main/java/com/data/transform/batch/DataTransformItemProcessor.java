package com.data.transform.batch;

import org.springframework.batch.item.ItemProcessor;

import com.data.transform.dto.HistoryDataDto;
import com.data.transform.entity.HistoryData;

public class DataTransformItemProcessor implements ItemProcessor<HistoryData, HistoryDataDto> {

	@Override
	public HistoryDataDto process(HistoryData item) throws Exception {
		HistoryDataDto transformed=new HistoryDataDto();
		transformed.setId(item.getId());
		transformed.setName(item.getName());
		transformed.setStartDate(item.getStartDate());
		transformed.setEndDate(item.getEndDate());
		transformed.setPrimaryKpi(item.getPrimaryKpi());
		transformed.setSecondaryKpi(item.getSecondaryKpi());
		transformed.setUniqueId(item.getId() +" "+ item.getName());
		return transformed;
		
	}

}
