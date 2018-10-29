package presentation;

import domain.IProjectPortfolioManager;

public class ResourceMenu {
	private IProjectPortfolioManager mediator;
	
	public ResourceMenu(IProjectPortfolioManager mediator) {
		System.out.println("ResouceMenu constructor...");
		setMediator(mediator);
	}
	
	public void setMediator(IProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	
	public void startManage() {
		
	}
	
	public void startDisplay() {
		
	}
}
