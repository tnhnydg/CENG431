package domain;

import java.util.ArrayList;
import java.util.Date;

public class Activity {

	private int number;
	private String description;
	private Date startDate;
	private String deliverable;
	private ArrayList<Task> taskList;
	private ProjectPortfolioManager mediator;
	
	
	public ArrayList<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}
	public ProjectPortfolioManager getMediator() {
		return mediator;
	}
	public void setMediator(ProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeliverable() {
		return deliverable;
	}
	public void setDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}
	public int getHours() //Iterate in tasklist and return total duration
	{
		return 0;
	}
	
	
}
