package com.data.transform.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class HistoryDataDto {
	
	private int id;
	private String name ;
	private String startDate;

	private String endDate;
	

	private String primaryKpi;
	private String secondaryKpi;
	private String uniqueId;
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPrimaryKpi() {
		return primaryKpi;
	}
	public void setPrimaryKpi(String primaryKpi) {
		this.primaryKpi = primaryKpi;
	}
	public String getSecondaryKpi() {
		return secondaryKpi;
	}
	public void setSecondaryKpi(String secondaryKpi) {
		this.secondaryKpi = secondaryKpi;
	}
	@Override
	public String toString() {
		return "HistoryDataDto [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", primaryKpi=" + primaryKpi + ", secondaryKpi=" + secondaryKpi + ", uniqueId=" + uniqueId + "]";
	}
	
}
