package domain;

import java.util.List;

public interface IResource {
	public void setId(int id);
	public int getId();
	public void setTaskList(List<Task> taskList);
	public List<Task> getTaskList();
	public void setDescription(String decription);
	public String getDescription();
	public void setMediator(ProjectPortfolioManager mediator);

}
