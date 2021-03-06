package domain;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.Date;

import java.util.List;
import java.util.Set;

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
	
	public Task assignResource(Project project,int aNum,int tNum,int rId) {
		Activity activity = null;
		for(int i=0;i<this.getActivityList().size();i++) {
			if(this.getActivityList().get(i).getNumber() == aNum) {
				activity = this.getActivityList().get(i);
			}
		}
		
		Task task = (activity.assignResource(project,aNum,tNum,rId));
		
		return task;
	}
	
	public Task unassignResource(Project project,int aNum,int tNum,int rId) {
		Activity activity = null;
		for(int i=0;i<this.getActivityList().size();i++) {
			if(this.getActivityList().get(i).getNumber() == aNum) {
				activity = this.getActivityList().get(i);
			}
		}
		
		Task task = (activity.unassignResource(project,aNum,tNum,rId));
		
		return task;
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
	public int calculateProject() {
		int totalProjectHours = 0;
		for(int i = 0; i < getActivityList().size(); i++) {
			totalProjectHours += getActivityList().get(i).calculateActivity();
		}
		System.out.println("Total Project Hour:" + totalProjectHours);
		return totalProjectHours;
	}
	
	public int calculateActivity(int aId) {
		return findActivity(aId).calculateActivity();
	}
	
	public int calculateTask(int aId, int tId) {
		return findActivity(aId).calculateTask(tId);
	}
	
	public Activity findActivity(int aId) {
		for(int i = 0; i < getActivityList().size(); i++) {
			Activity tmp = getActivityList().get(i);
			if(tmp.getNumber() == aId) {
				return tmp;
			}
		}
		return null;
	}
	public int countProjectResource() {
		Set<Integer> projectResource = new HashSet<Integer>();
		for(int i = 0; i < getActivityList().size(); i++) {
			Activity tmp = getActivityList().get(i);
			projectResource.addAll(tmp.countActivityResouce());
		}
		return projectResource.size();
	}
	
	public int countActivityResource(int aId) {
		return findActivity(aId).countActivityResouce().size();
	}
	
	public int countTaskResource(int aId, int tId) {
		//findActivity(aId).countTaskResource(tId)
		return 1;
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
