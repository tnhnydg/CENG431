package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

	private String name;
	private String description;
	private String startDate;
	private List<Activity> activityList;
	private ProjectPortfolioManager mediator;
	
	public Project(String pName, String description, String startDate) {
		setName(pName);
		setDescription(description);
		setStartDate(startDate);
		setActivityList(new ArrayList<Activity>());
	}
	
	public void addActivity(Project project,int aNumber,String aDescription,String aStartDate,String aDeliverable) {
		Activity activity = new Activity(aNumber,aDescription,aStartDate,aDeliverable);
		project.getActivityList().add(activity);
		//activity.addTask(activity,tdescription,tstarDate,thours);
	}
	
	public List<Activity> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<Activity> activityList) {
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}
