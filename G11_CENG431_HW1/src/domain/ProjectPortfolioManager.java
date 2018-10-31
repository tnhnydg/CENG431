package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectPortfolioManager implements IProjectPortfolioManager {

	private List<Project> allProjects;
	private List<IResource> allPerson;
	
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
	
	public void removeProject(String pName) {
		
		Project project = null;
		
		for(int i=0;i<getAllProjects().size();i++) {
			if((getAllProjects().get(i).getName()).equals(pName)) {
				project = getAllProjects().get(i);
			}
		}
		
		List<Task> taskList = fetchTasks(project);
		
		for(int i=0;i<taskList.size();i++) {
			IResource person = findPerson(taskList.get(i).getResourceId());
			for(int j=0;j<person.getTaskList().size();j++) {
				if(person.getTaskList().get(j).equals(taskList.get(i))) {
					person.getTaskList().remove(j);
				}
			}
			
		}
		
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).equals(project)) {
				getAllProjects().remove(i);
			}
		}
		
	}
	
	public void removeActivity(String pName,int aNumber) {
		
		Project project = null;
		
		project = findProject(pName);
		
		List<Task> taskList = fetchTasks(project,aNumber);
		
		for(int i=0;i<taskList.size();i++) {
			IResource person = findPerson(taskList.get(i).getResourceId());
			for(int j=0;j<person.getTaskList().size();j++) {
				if(person.getTaskList().get(j).equals(taskList.get(i))) {
					person.getTaskList().remove(j);
				}
			}
			
		}
		
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).equals(project)) {
				for(int j=0;j<project.getActivityList().size();j++) {
					if(project.getActivityList().get(j).getNumber() == aNumber) {
						project.getActivityList().remove(j);
					}
				}
			}
		}
		
	}
	
	public void removeTask(String pName, int aNumber, int tNumber) {
		
		int pId = 0;
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).getName().equals(pName)) {
				for(int j=0;j<getAllProjects().get(i).getActivityList().size();j++) {
					if(getAllProjects().get(i).getActivityList().get(j).getNumber() == aNumber) {
						for(int k=0;k<getAllProjects().get(i).getActivityList().get(j).getTaskList().size();k++) {
							if(getAllProjects().get(i).getActivityList().get(j).getTaskList().get(k).getNumber() == tNumber) {
								pId = getAllProjects().get(i).getActivityList().get(j).getTaskList().get(k).getResourceId();
							}
						}
					}
				}
			}
		}
		IResource person = findPerson(pId);
		for(int j=0;j<person.getTaskList().size();j++) {
			if(person.getTaskList().get(j).getNumber() == tNumber) {
				person.getTaskList().remove(j);
			}
		}
		
		for(int i=0;i<getAllProjects().size();i++) {
			if(getAllProjects().get(i).getName().equals(pName)) {
				for(int j=0;j<getAllProjects().get(i).getActivityList().size();j++) {
					if(getAllProjects().get(i).getActivityList().get(j).getNumber() == aNumber) {
						for(int k=0;k<getAllProjects().get(i).getActivityList().get(j).getTaskList().size();k++) {
							if(getAllProjects().get(i).getActivityList().get(j).getTaskList().get(k).getNumber() == tNumber) {
								getAllProjects().get(i).getActivityList().get(j).getTaskList().remove(k);
							}
						}
					}
				}
			}
		}
		
		
	}
	
	public IResource findPerson(int pId) {
		
		IResource person = null;
		
		for(int i=0;i<getResourceList().size();i++) {
			if(getResourceList().get(i).getId() == pId) {
				person = getResourceList().get(i);
			}
		}
		
		return person;
	}	
	
	public List<Task> fetchTasks(Project project){//tasklist that has tasks to be removed
		
		List<Task> taskList = new ArrayList<Task>();
		
		for(int i=0;i<project.getActivityList().size();i++) {
			for(int j=0;j<project.getActivityList().get(i).getTaskList().size();j++) {
				taskList.add(project.getActivityList().get(i).getTaskList().get(j));
			}
		}
		
		return taskList;
	}
	
	public List<Task> fetchTasks(Project project,int aNumber){
		
		List<Task> taskList = new ArrayList<Task>();
		
		for(int i=0;i<project.getActivityList().size();i++) {
			if(project.getActivityList().get(i).getNumber() == aNumber) {
				for(int j=0;j<project.getActivityList().get(i).getTaskList().size();j++) {
					taskList.add(project.getActivityList().get(i).getTaskList().get(j));
				}
			}
		}
		
		return taskList;
	}
	
	public void assignResource(String pName,int aNumber,int tNumber,int rId) {
		Project project = findProject(pName);
		
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

	public void setResourceList(List<IResource> person) {
		this.allPerson = person;
	}
	
	public List<IResource> getResourceList() {
		return this.allPerson;
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
	
		return null;
	}
	
	public int calculateProject(String pName) {
		return findProject(pName).calculateProject();
	}
	
	public int calculateActivity(String pName, int aId) {
		//talks project
		return findProject(pName).calculateActivity(aId);
	}
	
	public int calculateTask(String pName, int aId, int tId) {
		//talks project
		return findProject(pName).calculateTask(aId, tId);
	}
	
	public Project findProject(String pName) {
		for(int i = 0; i < getAllProjects().size(); i++) {
			Project tmp = getAllProjects().get(i);
			if(tmp.getName().equals(pName)) {
				return tmp;
			}
		}
		return null;
	}
}
