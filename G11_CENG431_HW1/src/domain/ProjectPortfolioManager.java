package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataAccess.DataHandler;
import presentation.MainMenu;

public class ProjectPortfolioManager implements IProjectPortfolioManager {

	private List<Project> allProjects;
	private List<IResource> resources;
	
	public ProjectPortfolioManager() {

		setAllProjects(new ArrayList<Project>());
		setResourceList(new ArrayList<IResource>());

	}
	
	public void addProject(String pName, String pDescription, String pDate) {
		Project newProject = new Project(pName,pDescription,pDate);
		addToList(newProject);
	}
	
	public int addActivity(String pName,String aDescription,String aStartDate,String aDeliverable) {
		Project project = null;
		for(int i=0;i<getAllProjects().size();i++) {
			//System.out.println("1: " + getAllProjects().get(i).getName());
			//System.out.println("2: " + pName);
			if(getAllProjects().get(i).getName().equals(pName)) {
				//System.out.println("Mediator addactivity");
				project = getAllProjects().get(i);
			}
		}
		//System.out.println("Projects :" + getAllProjects().toString());
		//System.out.println(project);
		project.addActivity(project,aDescription,aStartDate,aDeliverable);
		
		int size = project.getActivityList().size();
		int aNumber = project.getActivityList().get(size - 1).getNumber();
		//System.out.println(aNumber);
		return aNumber;
	}
	
	public void addTask(String pName,int aNumber,String tDescription,String tStartDate,int tHours) {
		Project project = null;
		Activity activity = null;
		for(int i=0;i<getAllProjects().size();i++) {
			if((getAllProjects().get(i).getName()).equals(pName)) {
				project = getAllProjects().get(i);
				//System.out.println(project.getDescription());
				//System.out.println(project.getActivityList().get(0).getNumber());
				
				for(int j=0;j<project.getActivityList().size();j++) {
					//System.out.println("A:" + project.getActivityList().get(j).getNumber());
					if((project.getActivityList().get(j).getNumber()) == aNumber ) {
						//System.out.println("found2");
						activity = project.getActivityList().get(j);
					}
				}
			}
		}
		//System.out.println("Activity : " + activity);
		activity.addTask(activity, tDescription, tStartDate, tHours);
		
	}
	
	public void removeProject(String Pname) {
		
		
		
	}
	
	/*public void unAssignResource() {
		
	}*/
	
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
		IResource employee = new Employee(eName, eDescription, rId);
		employee.setMediator(this);
		getResourceList().add(employee);
				
		return true;
	}
	
	public boolean addEmployeeResource(String eName, String eDescription) {
		IResource employee = new Employee(eName, eDescription);
		System.out.println("Resource ID:" + employee.getId());
		employee.setMediator(this);
		getResourceList().add(employee);
		
		return true;
	}

	public boolean addConsultantResource(String cName, String cDescription, int rId) {
		IResource consultant = new Consultant(cName, cDescription, rId);
		consultant.setMediator(this);
		getResourceList().add(consultant);
	
		return true;
	}
	
	public boolean addConsultantResource(String cName, String cDescription) {	
		IResource consultant = new Consultant(cName, cDescription);
		System.out.println("Resource ID:" + consultant.getId());
		consultant.setMediator(this);
		getResourceList().add(consultant);
		
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
	
	public boolean updateResource(String rName, String rDescription, int rId) {
		for(int i = 0; i < getResourceList().size(); i++) {
			if(rId == getResourceList().get(i).getId()) {
				Person tmp = ((Person)getResourceList().get(i));
				tmp.setName(rName);
				tmp.setDescription(rDescription);
				
				System.out.println(getResourceList());
				return true;
			}
		}	
		return false;
	}

	public String showResource(int rId) {
		for(int i = 0; i < getResourceList().size(); i++) {
			if(rId == getResourceList().get(i).getId()) {
				return getResourceList().get(i).toString();	
			}
		}
		return "Resource Not Found";
	}
	
	public void start() {
		MainMenu menu = new MainMenu(this);
		menu.start();	
	}
	
	public void saveState() {
		//DataHandler data = new DataHandler();
		//data.mergeJson(getAllProjects(), getResourceList());
		
	}
	
	public void loadState() {
		
	}
}
