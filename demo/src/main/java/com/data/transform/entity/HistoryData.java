package com.data.transform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="History_Data")
public class HistoryData {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name ;
	
	@Column(name="startDate")
	private String startDate;

	@Column(name="endDate")
	private String endDate;
	

	@Column(name="primaryKpi")
	private String primaryKpi;
	@Column(name="secondaryKpi")
	private String secondaryKpi;
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
	
}
