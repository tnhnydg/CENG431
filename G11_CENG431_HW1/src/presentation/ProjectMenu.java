package presentation;

import domain.IProjectPortfolioManager;

public class ProjectMenu {
	private IProjectPortfolioManager mediator;
	
	public ProjectMenu(IProjectPortfolioManager mediator) {
		System.out.println("ProjectMenu constructor..");
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
