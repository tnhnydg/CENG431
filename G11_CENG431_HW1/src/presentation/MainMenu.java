package presentation;

import domain.IProjectPortfolioManager;

public class MainMenu {
	private IProjectPortfolioManager mediator;
	private ProjectMenu project;
	private ResourceMenu resource;
	
	public MainMenu(IProjectPortfolioManager mediator) {
		System.out.println("Main Menu Constructor...");
		
		setMediator(mediator);
		
		createProjectMenu(getProjectMenu());
		createResourceMenu(getResourceMenu());
	}
	
	public void setMediator(IProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	
	private IProjectPortfolioManager getMediator() {
		return this.mediator;
	}
	
	public void setProjectMenu(ProjectMenu project) {
		this.project = project;
	}
	
	public void setResourceMenu(ResourceMenu resource) {
		this.resource = resource;
	}
	
	public void createProjectMenu(ProjectMenu project) {
		this.project = new ProjectMenu(getMediator());
	}
	
	public void createResourceMenu(ResourceMenu resource) {
		this.resource = new ResourceMenu(getMediator());
	}
	
	private ProjectMenu getProjectMenu() {
		return this.project;
	}
	
	private ResourceMenu getResourceMenu() {
		return this.resource;
	}
		
	public void start() {
		
	}

}
