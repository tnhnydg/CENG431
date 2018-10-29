package presentation;

import java.util.Scanner;

import domain.IProjectPortfolioManager;

public abstract class Menu {
	private IProjectPortfolioManager mediator;
	private Scanner input;
	
	public void setMediator(IProjectPortfolioManager mediator) {
		this.mediator = mediator;
	}
	
	public IProjectPortfolioManager getMediator() {
		return mediator;
	}
	
	public void setScanner(Scanner input) {
		this.input = input;
	}
	
	public Scanner getScanner() {
		return this.input;
	}
	
	public String takeInput() {
		String line = getScanner().nextLine();
		return line;
	}
	
}
