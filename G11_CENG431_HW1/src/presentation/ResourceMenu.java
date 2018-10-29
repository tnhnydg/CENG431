package presentation;

import java.util.Scanner;

import domain.IProjectPortfolioManager;

public class ResourceMenu extends Menu {
	
	public ResourceMenu(IProjectPortfolioManager mediator, Scanner input) {
		System.out.println("ResourceMenu constructor...");
		setMediator(mediator);
		setScanner(input);
	}
	
	public void startManage() {
		System.out.println("Resource startManage..");
		System.out.println(takeInput());
	}
	
	public void startDisplay() {
		System.out.println("Resource startDisplay");
		System.out.println(takeInput());
	}
	
	public void startFindResource() {
		System.out.println("Resource startFindResource");
	}
}
