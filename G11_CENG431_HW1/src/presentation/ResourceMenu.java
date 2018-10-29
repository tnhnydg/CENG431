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
		System.out.println("Resource addResource");
	}
	
	public void removeResource(String rId) {
		//signature not final
		System.out.println("Resource removeResource");
	}
	
	public void updateResource(String rId) {
		//signature not final
		System.out.println("Resource updateResource");
	}
	
}
