package domain;

import java.util.Date;

public interface IProjectPortfolioManager {

	public void addProject(String pName, String pDescription, Date pDate);
	public void updateActivityInfo(String pName,String aNumber,String description,Date startDate,String deliverable);
	public boolean addEmployeeResource(String eName, String eDescription);
	public boolean addEmployeeResource(String eName, String eDescription, int rId);
}
