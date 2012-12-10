package com.fnz.VO;

import javafx.beans.property.SimpleStringProperty;

public class FinshedProductVO 
{
	private String dateOfProduction;
	private int bricksProduced;	
	private String daysCured;
	private String storageSection;
	private String status;
	
	
	public String getDateOfProduction() {
		return dateOfProduction;
	}
	public void setDateOfProduction(String dateOfProduction) {
		this.dateOfProduction = dateOfProduction;
	}
	public int getBricksProduced() {
		return bricksProduced;
	}
	public void setBricksProduced(int bricksProduced) {
		this.bricksProduced = bricksProduced;
	}
	public String getDaysCured() {
		return daysCured;
	}
	public void setDaysCured(String daysCured) {
		this.daysCured = daysCured;
	}
	public String getStorageSection() {
		return storageSection;
	}
	public void setStorageSection(String storageSection) {
		this.storageSection = storageSection;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
		
	
}
