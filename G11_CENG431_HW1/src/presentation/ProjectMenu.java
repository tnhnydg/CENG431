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
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.print("Project Description:");
			String pDescription = takeInput();
			
			System.out.print("Project Date(DD:MM:YYYY):");
			String pDate = takeInput();
			
			addProject(pName, pDescription, pDate);	
		}
		else if(input.equals("2")) {
			//remove project
			//removeProject(pName);
			System.out.print("Project Name:");
			String pName = takeInput();
			
			removeProject(pName);
		}
		else if(input.equals("3")) {
			//update project
			//updateProject();
			System.out.println("\t<<<Project Update Menu>>>");
			System.out.println("1-Activity\n2-Resource\nq:to quit");
			
			input = takeInput();
			
			if(input.equals("1")) {
				updateActivity();
			}
			else if(input.equals("2")) {
				updateResource();
			}
			else if(input.toLowerCase().equals("q")) {
				System.out.println("q is selected");
			}
			else {
				System.out.println("Invalid input");
			}
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
		System.out.println("\t<<<Update Activity Menu>>>");
		System.out.println("1-Add\n2-Remove\n3-Update\nq:to quit");
		
		String input = takeInput();
		
		if(input.equals("1")) {
			//addActivity()
			System.out.print("Activity Name:");
			String aName = takeInput();
			
			System.out.print("Activity Description:");
			String aDescription = takeInput();
			
			addActivity(aName, aDescription);
		}
		else if(input.equals("2")) {
			//removeActivity()
			System.out.print("Activity Name:");
			String aName = takeInput();
			
			System.out.println("/t<<<Remove Activity or Task Menu>>>");
			System.out.println("1-Activity\n2-Task\nq:to quit");
			input = takeInput();
			
			if(input.equals("1")) {
				removeActivity(aName);
			}
			else if(input.equals("2")) {
				System.out.print("Task Name:");
				String tName = takeInput();
				
				removeTask(aName, tName);
			}
			else if(input.toLowerCase().equals("q")) {
				
			}
			else {
				
			}
		}
		else if(input.equals("3")) {
			System.out.println("UpdateActivity");
			//updateActivity ???
			//adding task to activity more than one ???
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}

	}
	
	public void addActivity(String aName, String aDescription) {
		//signature not final
		//Each activity should have at least one task.
		System.out.print("Task Name:");
		String tName = takeInput();
		
		System.out.print("Task Description:");
		String tDescription = takeInput();
		
		System.out.print("Task start date:");
		String tStartDate = takeInput();
		
		System.out.print("Task hour:");
		String tHours = takeInput();
		
		//Mediator activity creation ???
		addTask(tName, tDescription, tStartDate, tHours);
		
	}
	
	public void removeActivity(String aName) {
		//signature not final
	}
	
	public void removeTask(String aName, String tName) {
		//signature not final
	}
	
	public void updateResource() {
		//signature not final
		System.out.println("Project updateResource");
	}
	
	public void addTask(String tName, String tDescription, String tStartDate, String tHours) {
		//signature not final
		//Mediator Task creation for latest project latest activity ???
	}
	
}
