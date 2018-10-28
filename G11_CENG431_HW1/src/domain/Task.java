package domain;

import java.util.Date;

public class Task {

	private int number;
	private String desription;
	private Date startDate;
	private int hours;
	private int resourceId;
	private ProjectPortfolioManager mediator;
	public String getDesription() {
		return desription;
	}
	public void setDesription(String desription) {
		this.desription = desription;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public ProjectPortfolioManager getMediator() {
		return mediator;
	}
	public void setMediator(ProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
}
