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
	
	
	public Activity(String aDescription, String aStartDate, String aDeliverable) {
		setDescription(aDescription);
		setStartDate(aStartDate);
		setDeliverable(aDeliverable);
		setTaskList(new ArrayList<Task>());

	}
	
	public void addTask(Activity activity,String tDescription,String tStartDate,int tHours) {
		Task task = new Task(tDescription,tStartDate,tHours);
		assignNumber(activity,task);
		activity.getTaskList().add(task);
	}
	
	public void assignNumber(Activity activity,Task task) {
		int tNumber;
		if(activity.getTaskList().size() != 0) {
			tNumber = activity.getTaskList().get(-1).getNumber();
		}
		else {
			tNumber = 0;
		}
		
		task.setNumber(tNumber+1);
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
	public void setNumber(int aNumber) {
		this.number = aNumber;
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
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[" + this.getNumber() + this.getDescription() + this.getStartDate() + this.getDeliverable() + this.getHours() + " : ");  
		for(int i=0;i<this.getTaskList().size();i++) {
			str.append("\n\t" + this.getTaskList().get(i).toString());
		}
		
		return str.toString(); 
	}
	
	
}
