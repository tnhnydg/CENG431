package presentation;

import java.util.Scanner;

import domain.IProjectPortfolioManager;

public class MainMenu extends Menu {
	private ProjectMenu project;
	private ResourceMenu resource;
	
	public MainMenu(IProjectPortfolioManager mediator) {
		System.out.println("Main Menu Constructor...");
		
		setMediator(mediator);
		setScanner(new Scanner(System.in));
	
		createProjectMenu(getProjectMenu());
		createResourceMenu(getResourceMenu());
		
	}
	
	public void setProjectMenu(ProjectMenu project) {
		this.project = project;
	}
	
	public void setResourceMenu(ResourceMenu resource) {
		this.resource = resource;
	}
	
	public void createProjectMenu(ProjectMenu project) {
		this.project = new ProjectMenu(getMediator(), getScanner());
	}
	
	public void createResourceMenu(ResourceMenu resource) {
		this.resource = new ResourceMenu(getMediator(), getScanner());
	}
	
	private ProjectMenu getProjectMenu() {
		return this.project;
	}
	
	private ResourceMenu getResourceMenu() {
		return this.resource;
	}
	
	private void startScreen() {
		System.out.println("\t\t<<<Project Management System>>>");
		System.out.println("- You can navigate between menus using option choices");
	}
		
	public void start() {
		
		while(true) {
			startScreen();
			System.out.println("1-Manage\n2-Display\n3-Calculate\n4-Find Resources(#ofRes)\nq-to quit");
			
			String input = takeInput();
			
			if(input.equals("1")) {
				System.out.println("\t<<<Manage Menu>>>");
				System.out.println("1-Project\n2-Resource\nq:to quit");
				
				input = takeInput();
				
				if(input.equals("1")) {
					project.startManage();
				}
				else if(input.equals("2")) {
					resource.startManage();
				}
				else if(input.toLowerCase().equals("q")) {
					System.out.println("Quit selected");
				}
				else {
					System.out.println("Invalid option selected");
				}
			}
			else if(input.equals("2")) {
				
				while(true) {
					System.out.println("\t<<<Display Menu>>>");
					System.out.println("1-Project\n2-Resource\nq:to quit");
					
					input = takeInput();
					
					if(input.equals("1")) {
						project.startDisplay();
					}
					else if(input.equals("2")) {
						resource.startDisplay();
					}
					else if(input.toLowerCase().equals("q")) {
						break;
					}
					else {
						System.out.println("Invalid option selected");
					}
				}
			}
			else if(input.equals("3")) {
				project.startCalculate();
			}
			else if(input.equals("4")) {
				resource.startFindResource();
			}
			else if(input.toLowerCase().equals("q")) {
				System.out.print("Before Quit Current Date(YYYY-MM-DD):");
				String currentDate = takeInput();
				getMediator().saveState(currentDate);
				break;
			}
			else {
				System.out.println("Invalid option");
			}
		}
		getScanner().close();
	}
	
}
