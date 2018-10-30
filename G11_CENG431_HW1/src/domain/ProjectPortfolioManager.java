package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectPortfolioManager implements IProjectPortfolioManager {

	private List<Project> allProjects;
	private List<IResource> resources;
	
	public ProjectPortfolioManager() {

		setAllProjects(new ArrayList<Project>());

		allProjects = new ArrayList<Project>();
		setResourceList(new ArrayList<IResource>());

	}
	
	public void addProject(String pName, String pDescription, String pDate) {
		Project newProject = new Project(pName,pDescription,pDate);
		addToList(newProject);
	}
	
	public int addActivity(String pName,String aDescription,String aStartDate,String aDeliverable) {
		Project project = null;
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).getName() == pName) {project = getAllProjects().get(i);}
		}
		project.addActivity(project,aDescription,aStartDate,aDeliverable);
		
		int aNumber = project.getActivityList().get(-1).getNumber();
		
		return aNumber;
	}
	
	public void addTask(String pName,int aNumber,String tDescription,String tStartDate,int tHours) {
		Project project = null;
		Activity activity = null;
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).getName() == pName) {
				project = getAllProjects().get(i);
				//System.out.println(project.getDescription());
				//System.out.println(project.getActivityList().get(0).getNumber());
				
				for(int j=0;j<project.getActivityList().size();j++) {
					if(project.getActivityList().get(i).getNumber() == aNumber) {
						//System.out.println("found2");
						activity = project.getActivityList().get(i);
					}
				}
			}
		}
		//System.out.println(activity.getNumber());
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

	public void setResourceList(List<IResource> resources) {
		this.resources = resources;
	}
	
	public List<IResource> getResourceList() {
		return this.resources;
	}
	
	public boolean addEmployeeResource(String eName, String eDescription, int rId) {
		System.out.println("addEmployeeResource");
		
		IResource employee = new Employee(eName, eDescription, rId);
		employee.setMediator(this);
		
		getResourceList().add(employee);
		
		System.out.println(getResourceList());
		
		return true;
	}
	
	public boolean addEmployeeResource(String eName, String eDescription) {
		System.out.println("addEmployeeResource without id");
		
		IResource employee = new Employee(eName, eDescription);
		employee.setMediator(this);
		
		getResourceList().add(employee);
		
		System.out.println(getResourceList());
		
		return true;
	}

	public boolean addConsultantResource(String cName, String cDescription, int rId) {
		System.out.println("addConsultantResource with id");
		
		IResource consultant = new Consultant(cName, cDescription, rId);
		consultant.setMediator(this);
		
		getResourceList().add(consultant);
		
		System.out.println(getResourceList());
		
		return true;
	}
	
	public boolean addConsultantResource(String cName, String cDescription) {
		System.out.println("addConsultantResource with id");
		
		IResource consultant = new Consultant(cName, cDescription);
		consultant.setMediator(this);
		
		getResourceList().add(consultant);
		
		System.out.println(getResourceList());
		
		return true;
	}
	
	public boolean removeResource(int rId) {
		for(int i = 0; i < getResourceList().size(); i++) {
			if(rId == getResourceList().get(i).getId()) {
				getResourceList().remove(i);
				System.out.println(getResourceList());
				return true;
			}
		}
		
		return false;
	}
	

}
