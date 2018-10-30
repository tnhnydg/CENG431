package domain;

import java.util.List;

public abstract class Person implements IResource {
	private IProjectPortfolioManager mediator;
	private int id;
	private String name;
	private String description;
	private List<Task> tasks;
	
	public Person() {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {	
		this.name = name;
	}
	
	@Override
	public void setMediator(IProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	
	@Override
	public IProjectPortfolioManager getMediator() {
		return this.mediator;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public void setTaskList(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public List<Task> getTaskList() {
		return this.tasks;
	}
	

}
