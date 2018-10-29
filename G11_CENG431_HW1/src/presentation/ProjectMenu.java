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
		System.out.println("\t<<<Project Manage Menu>>>");
		System.out.println("1-Add\n2-Remove\n3-Update\nq-to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			//add project
			//addProject(pName, pDescription, pDate);
		}
		else if(input.equals("2")) {
			//remove project
			//removeProject(pName);
		}
		else if(input.equals("3")) {
			//update project
			//updateProject();
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void startDisplay() {
		System.out.println("Project displayManage");
		System.out.println(takeInput());
	}
	
	public void startCalculate() {
		System.out.println("Project startCalculate");
		
	}
	
	public void addProject(String pName, String pDescription, String pDate) {
		//signature not final
		//where we handle the date
	}
	
	public void removeProject(String pName) {
		//signature not final
	}
	
	public void updateProject() {
		//signature not final
		//updateActivity();
		//updateResource();
	}
	
	public void updateActivity() {
		//signature not final
		//addActivity();
		//removeActivity();
		//??? I am not sure how to handle updating a activity option
	}
	
	public void addActivity(String aDescription) {
		//signature not final
	}
	
	public void removeActivity(String aName) {
		//signature not final
	}
	
	public void removeTask(String tName) {
		//signature not final
	}
	
	public void updateResource() {
		//signature not final
	}
	
	public void addTask() {
		//signature not final
	}
	
}
