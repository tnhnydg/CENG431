package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectPortfolioManager implements IProjectPortfolioManager {

	private List<Project> allProjects;
	
	public ProjectPortfolioManager() {
		allProjects = new ArrayList<Project>();
	}
	
	public void addProject(String pName, String pDescription, Date pDate) {
		Project newProject = new Project(pName,pDescription,pDate);
		
		addToList(newProject);
	}
	
	public void addActivity() {}
	
	public void updateActivityInfo(String pName,String aNumber,String description,Date startDate,String deliverable) {}
		
	public void addToList(Project project) {
		allProjects.add(project);
	}
}
