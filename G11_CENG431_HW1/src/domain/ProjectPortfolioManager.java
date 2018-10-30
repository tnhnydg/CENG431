package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectPortfolioManager implements IProjectPortfolioManager {

	private List<Project> allProjects;
	private List<IResource> resources;
	
	public ProjectPortfolioManager() {
		allProjects = new ArrayList<Project>();
		setResourceList(new ArrayList<IResource>());
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
	
	public void setResourceList(List<IResource> resources) {
		this.resources = resources;
	}
	
	public List<IResource> getResourceList() {
		return this.resources;
	}
	
	public boolean addEmployeeResource(String eName, String eDescription, int rId) {
		System.out.println("addEmployeeResource");
		IResource employee = new Employee(eName, eDescription, rId);
		
		//add to meadiator resource list
		getResourceList().add(employee);
		
		return true;
	}
	
	public boolean addEmployeeResource(String eName, String eDescription) {
		System.out.println("addEmployeeResource without id");
		IResource employee = new Employee(eName, eDescription);
		
		//add to mediator resource list
		getResourceList().add(employee);
		
		return false;
	}
	
	
}
