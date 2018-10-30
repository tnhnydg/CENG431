package domain;

import java.util.List;

public interface IResource {
	public void setMediator(IProjectPortfolioManager mediator);
	public IProjectPortfolioManager getMediator();
	public void setDescription(String decription);
	public String getDescription();
	public void setTaskList(List<Task> taskList);
	public List<Task> getTaskList();
	public void setId(int id);
	public int getId();
	public int generateId();
}
