package domain;

import java.util.ArrayList;
import java.util.Date;

public class Project {

	private String name;
	private String description;
	private Date startDate;
	private ArrayList<Activity> activityList;
	private ProjectPortfolioManager mediator;
	
	
	public ArrayList<Activity> getActivityList() {
		return activityList;
	}
	public void setActivityList(ArrayList<Activity> activityList) {
		this.activityList = activityList;
	}
	public ProjectPortfolioManager getMediator() {
		return mediator;
	}
	public void setMediator(ProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
