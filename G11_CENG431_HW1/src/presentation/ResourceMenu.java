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
			//add resource
			addResource();
		}
		else if(input.equals("2")) {
			//remove resource
			System.out.print("Resource Id:");
			String rId = takeInput();
			
			removeResource(rId);
		}
		else if(input.equals("3")) {
			//update resource
			System.out.println("Resource Id:");
			String rId = takeInput();
			
			updateResource(rId);
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void startDisplay() {
		System.out.println("Resource startDisplay");
		System.out.println(takeInput());
	}
	
	public void startFindResource() {
		System.out.println("Resource startFindResource");
	}
	
	public void addResource() {
		//signature not final
		System.out.println("\t<<<Resource Add Menu>>>");
		
		System.out.println("1-Employee(Interval?)\n2-Consultant(Interval?)\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			//add employee
			//eName, eDescription
			System.out.print("Employee Name:");
			String eName = takeInput();
			
			System.out.print("Employee Description:");
			String eDescription = takeInput();
			
			addEmployee(eName, eDescription);			
		}
		else if(input.equals("2")) {
			//add consultant
			System.out.print("Consultant Name:");
			String cName = takeInput();
			
			System.out.print("Consultant Description:");
			String cDescription = takeInput();
			
			addConsultant(cName, cDescription);
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void removeResource(String rId) {
		//signature not final
		System.out.println("Resource removeResource");
	}
	
	public void updateResource(String rId) {
		//signature not final
		System.out.println("Resource updateResource");
		//find rId with Mediator ???
		//update Resource with Mediator ???
		
		System.out.print("Resource Name:");
		String rName = takeInput();
		
		System.out.print("Resource Description:");
		String rDescription = takeInput();
		
		//mediator update
	}
	
	public void addEmployee(String eName, String eDescription) {
		//signature not final
		System.out.println("\t<<<Employee Add Menu>>>");
		
		System.out.println("-Resource ID option:\n1-Auto\n2-Custom\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			System.out.println("Auto");
			
			//Generate rId ???
			//call mediator method ???
		}
		else if(input.equals("2")) {
			System.out.println("Custom");
			
			System.out.print("Resource ID:");
			String rId = takeInput();
			
			//call mediator method ???
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
	
	public void addConsultant(String cName, String cDescription) {
		//signature not final
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
}
