package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectPortfolioManager implements IProjectPortfolioManager {

	private List<Project> allProjects;
	
	public ProjectPortfolioManager() {
		setAllProjects(new ArrayList<Project>());
	}
	
	public void addProject(String pName, String pDescription, String pDate) {
		Project newProject = new Project(pName,pDescription,pDate);
		
		addToList(newProject);
	}
	
	public void addActivity(String pName,int aNumber,String aDescription,String aStartDate,String aDeliverable) {
		Project project = null;
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).getName() == pName) {project = getAllProjects().get(i);}
		}
		project.addActivity(project,aNumber,aDescription,aStartDate,aDeliverable);
		
		//return project;
	}
	
	public void addTask(String pName,int aNumber,String tName,String tDescription,String tStartDate,int tHours) {
		Project project = null;
		Activity activity = null;
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).getName() == pName) {
				project = getAllProjects().get(i);
				
				for(int j=0;j<project.getActivityList().size();j++) {
					if(project.getActivityList().get(i).getNumber() == aNumber) {
						activity = project.getActivityList().get(i);
					}
				}
			}
		}
		
		activity.addTask(activity, tDescription, tStartDate, tHours);
		
	}
	
	public void updateActivityInfo(String pName,String aNumber,String description,String startDate,String deliverable) {}
		
	public void addToList(Project project) {
		allProjects.add(project);
	}
	
	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects; 
	}
	
	public List<Project> getAllProjects(){
		return this.allProjects;
	}
}
