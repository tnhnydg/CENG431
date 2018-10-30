package domain;

import java.util.Date;

public interface IProjectPortfolioManager {


	public void addProject(String pName, String pDescription, String pDate);
	public void updateActivityInfo(String pName,String aNumber,String description,String startDate,String deliverable);
	public void addActivity(String pName,int aNumber,String aDescription,String aStartDate,String aDeliverable);
	public void addTask(String pName,int aNumber,String tName,String tDescription,String tStartDate,int tHours);
	public boolean addEmployeeResource(String eName, String eDescription);
	public boolean addEmployeeResource(String eName, String eDescription, int rId);
	public boolean addConsultantResource(String cName, String cDescription, int rId);
	public boolean addConsultantResource(String cName, String cDescription);
	public boolean removeResource(int rId);
	public boolean updateResource(String rName, String rDescription, int rId);
	public String showResource(int rId);
}
