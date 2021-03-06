package domain;

import java.util.Date;

public class Task {

	private int number;
	private String description;
	private String startDate;
	private int hours;
	private int resourceId; //We assumed it always has a resource

	
	public Task(String description,String startDate,int hours) {
		setDescription(description);
		setStartDate(startDate);
		setHours(hours);
		setResourceId(0);
	}
	

	public void assignResource(int rId) {
		this.setResourceId(rId);
	}
	
	public void unassignResource(int rId) {
		this.setResourceId(0);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	
	public int calculateTask() {
		return getHours();
	}
	
	public int countTaskResource() {
		return getResourceId();
	}
	
	@Override
	public String toString() { 
		return "[" + this.getNumber() + "," + this.getDescription() + "," + this.getStartDate() + "," + this.getHours() + "," + this.getResourceId() + "]";
	}
}
