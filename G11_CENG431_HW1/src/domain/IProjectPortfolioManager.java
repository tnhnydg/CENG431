package domain;

import java.util.Date;
import java.util.List;

public interface IProjectPortfolioManager {


	public void addProject(String pName, String pDescription, String pDate);
	public void updateActivityInfo(String pName,String aNumber,String description,String startDate,String deliverable);
	public int addActivity(String pName,String aDescription,String aStartDate,String aDeliverable);
	public void addTask(String pName,int aNumber,String tDescription,String tStartDate,int tHours);
	public boolean addEmployeeResource(String eName, String eDescription);
	public boolean addEmployeeResource(String eName, String eDescription, int rId);
	public boolean addConsultantResource(String cName, String cDescription, int rId);
	public boolean addConsultantResource(String cName, String cDescription);
	public boolean removeResource(int rId);
	public void setAllProjects(List<Project> allProjects);
	public List<Project> getAllProjects();
	public boolean updateResource(String rName, String rDescription, int rId);
	public String showResource(int rId);
	public void removeProject(String pName);
	public void setResourceList(List<IResource> allProjects);
	public List<IResource> getResourceList();
	public void removeActivity(String pName,int aNumber);
	public void removeTask(String pName, int aNumber, int tNumber);
	public void start();
	public void saveState(String currentDate);
	public void loadState();
	public int calculateProject(String pName);
	public int calculateActivity(String pName, int aId);
	public int calculateTask(String pName, int aId, int tId);
	public Project findProject(String pName);
	public int countActivityResource(String pName, int aId);
	public int countTaskResource(String pName, int aId, int tId);
	public int countProjectResource(String pName);
	public void assignResource(String pName,int aNumber,int tNumber,int rId);
	

}
