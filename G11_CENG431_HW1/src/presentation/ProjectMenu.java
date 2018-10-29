package presentation;

import java.util.Scanner;

import domain.IProjectPortfolioManager;

public class ProjectMenu extends Menu {
	
	public ProjectMenu(IProjectPortfolioManager mediator, Scanner input) {
		System.out.println("ProjectMenu constructor..");
		
		setMediator(mediator);
		setScanner(input);
		
	}
	
	public void startManage() {
		System.out.println("Project startManange...");
		System.out.println(takeInput());
	}
	
	public void startDisplay() {
		System.out.println("Project displayManage");
		System.out.println(takeInput());
	}
	
	public void startCalculate() {
		System.out.println("Project startCalculate");
	}



}
