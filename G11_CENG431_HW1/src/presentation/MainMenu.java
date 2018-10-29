package presentation;

import domain.IProjectPortfolioManager;

public class MainMenu {
	private IProjectPortfolioManager mediator;
	private ProjectMenu project;
	private ResourceMenu resource;
	
	public MainMenu(IProjectPortfolioManager mediator) {
		System.out.println("Main Menu Constructor...");
		setMediator(mediator);
	}
	
	public void setMediator(IProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	
	public void setProjectMenu(ProjectMenu project) {
		this.project = project;
	}
	
	public void setResourceMenu(ResourceMenu resource) {
		this.resource = resource;
	}
	
	public void start() {
		
	}

}
