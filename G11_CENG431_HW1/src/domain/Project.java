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
	
	public void addActivity(Project project,String aDescription,String aStartDate,String aDeliverable) {
		Activity activity = new Activity(aDescription,aStartDate,aDeliverable);
		assignNumber(project,activity);
		project.getActivityList().add(activity);
	}
	
	public void assignNumber(Project project, Activity activity) {
		int aNumber;
		if(project.getActivityList().size() != 0) {
			aNumber = project.getActivityList().get(project.getActivityList().size() - 1).getNumber();
		}
		else {
			aNumber = 0;
		}
		
		activity.setNumber(aNumber+1);
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
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[" + this.getName() + "," + this.getDescription() + "," + this.getStartDate() + " : ");  
		for(int i=0;i<this.getActivityList().size();i++) {
			str.append("\n\t" + this.getActivityList().get(i).toString());
		}
		
		return str.toString(); 
	}
}
