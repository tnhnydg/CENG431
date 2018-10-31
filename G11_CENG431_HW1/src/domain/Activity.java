package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity {

	private int number;
	private String description;
	private String startDate;
	private String deliverable;
	private List<Task> taskList;
	private ProjectPortfolioManager mediator;
	
	public Activity(int aNumber, String aDescription, String aStartDate, String aDeliverable) {
		setNumber(aNumber);
		setDescription(aDescription);
		setStartDate(aStartDate);
		setDeliverable(aDeliverable);
	}
	
	public void addTask(Activity activity,String tDescription,String tStartDate,int tHours) {
		Task task = new Task(tDescription,tStartDate,tHours);
		activity.getTaskList().add(task);
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
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
