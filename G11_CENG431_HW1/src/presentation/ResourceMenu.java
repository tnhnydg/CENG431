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
		System.out.println("\t<<<Resource Manage Menu>>>");
		System.out.println("1-Add\n2-Remove\n3-Update\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			addResource();
		}
		else if(input.equals("2")) {
			removeResource();
		}
		else if(input.equals("3")) {
			updateResource();
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void startDisplay() {
		System.out.print("Resource Name:");
		String rName = takeInput();
		
		//Mediator display call???
	}
	
	public void startFindResource() {
		System.out.println("\t<<<Find Resource Menu>>>");
		System.out.println("1-Project\n2-Activity\n3-Task\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			//find project
			findProject();
		}
		else if(input.equals("2")) {	
			System.out.print("Project Name:");
			String pName = takeInput();
			
			findActivity(pName);
		}
		else if(input.equals("3")) {	
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.print("Activity Name:");
			String aName = takeInput();
			
			findTask(pName, aName);
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
		
	}
	
	public void addResource() {
		//signature not final
		System.out.println("\t<<<Resource Add Menu>>>");
		
		System.out.println("1-Employee(Interval?)\n2-Consultant(Interval?)\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {			
			addEmployee();			
		}
		else if(input.equals("2")) {
			addConsultant();
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void removeResource() {
		//signature not final
		System.out.println("Resource removeResource");
		
		System.out.print("Resource Id:");
		String rId = takeInput();
		
		//Mediator code
	}
	
	public void updateResource() {
		//signature not final
		System.out.println("Resource updateResource");
		
		System.out.println("Resource Id:");
		String rId = takeInput();
		
		System.out.print("Resource Name:");
		String rName = takeInput();
		
		System.out.print("Resource Description:");
		String rDescription = takeInput();
		
		//mediator update
		//find rId with Mediator ???
		//update Resource with Mediator ???
	}
	
	public void addEmployee() {
		//signature not final
		
		System.out.print("Employee Name:");
		String eName = takeInput();
		
		System.out.print("Employee Description:");
		String eDescription = takeInput();
		
		System.out.println("\t<<<Employee Add Menu>>>");
		System.out.println("-Resource ID option:\n1-Auto\n2-Custom\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			System.out.println("Auto");
			getMediator().addEmployeeResource(eName, eDescription);
		}
		else if(input.equals("2")) {
			System.out.println("Custom");
			
			System.out.print("Resource ID:");
			String rId = takeInput();
			
			getMediator().addEmployeeResource(eName, eDescription, Integer.parseInt(rId));
		}
		else if(input.toLowerCase().equals("q")) {
			//Quit is selected
			System.out.println("Quit is selected");
		}
		else {
			//Invalid
			System.out.println("Invalid");
		}
	}
	
	public void addConsultant() {
		//signature not final
		
		System.out.print("Consultant Name:");
		String cName = takeInput();
		
		System.out.print("Consultant Description:");
		String cDescription = takeInput();
		
		System.out.println("\t<<<Consultant Add Menu>>>");
		
		System.out.println("-Resource ID option:\n1-Auto\n2-Custom\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			System.out.println("Auto");
			//generate Resource ID ???
			//call Mediator ???
		}
		else if(input.equals("2")) {
			System.out.println("Custom");
			
			System.out.print("Resource ID:");
			String rId = takeInput();
			
			//call Mediator ???
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void findProject() {
		//signature not final
		System.out.print("Project Name:");
		String pName = takeInput();
		
		//Mediator code
	}
	
	public void findActivity(String pName) {
		//signature not final
		
		System.out.print("Activity Name:");
		String aName = takeInput();
		
		//Mediator code
	}
	
	public void findTask(String pName, String aName) {
		//signature not final
		
		System.out.print("Task Name:");
		String tName = takeInput();
		
		//Mediator code
	}
}
