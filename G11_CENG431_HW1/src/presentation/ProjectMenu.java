package presentation;

import java.util.Date;
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
			updateProject();
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void startDisplay() {	
		System.out.print("Project Name:");
		String pName = takeInput();
		
		//Mediator display call ???
	}
	
	public void startCalculate() {
		System.out.println("<<<Calculate Menu>>>");
		System.out.println("1-Project\n2-Activity\n3-Task\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			//project calculate
			System.out.print("Project Name:");
			String pName = takeInput();
			
			projectCalculate(pName);
		}
		else if(input.equals("2")) {
			//activity calculate
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.print("Activity Name:");
			String aName = takeInput();
			
			activityCalculate(pName, aName);
		}
		else if(input.equals("3")) {
			//task calculate
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.print("Activity Name:"); 
			String aName = takeInput();
			
			System.out.print("Task Name:");
			String tName = takeInput();
			
			taskCalculate(pName, aName, tName);
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid option");
		}
		
		//Mediator calculate call ???
	}
	
	public void addProject(String pName, String pDescription, String pDate) {
		System.out.println("Project addProject");
		getMediator().addProject(pName,pDescription,pDate);
		addActivity(pName);
		//signature not final
		//where we handle the date
		//addActivity
		
		for(int i=0;i<getMediator().getAllProjects().size();i++) {
			System.out.println(getMediator().getAllProjects().get(i).toString());
		}//delete
	}
	
	public void removeProject(String pName) {
		System.out.println("Project removeProject");
		getMediator().removeProject(pName);
	}
	
	public void updateProject() {
		//signature not final
		//updateActivity();
		//updateResource();
		System.out.println("\t<<<Project Update Menu>>>");
		System.out.println("1-Activity\n2-Resource\nq:to quit");
		
		String input = takeInput();
		
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
	
	public void updateActivity() {
		//signature not final
		//addActivity();
		//removeActivity();
		//??? I am not sure how to handle updating a activity option
		System.out.println("\t<<<Update Activity Menu>>>");
		System.out.println("1-Add\n2-Remove\nq:to quit");
		//think method
		String input = takeInput();
		
		if(input.equals("1")) {
			//addActivity()
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.println("/t<<<Add Activity or Task Menu>>>");
			System.out.println("1-Activity\n2-Task\nq:to quit");
			
			if(input.equals("1")) {
				addActivity(pName);
			}
			else if(input.equals("2")) {
				
				System.out.print("Activity Number:");
				String aNumberr = takeInput();
				int aNumber = Integer.parseInt(aNumberr);
				
				addTask(pName, aNumber);
				//pName
			}
			else if(input.toLowerCase().equals("q")) {
				
			}
			else {
				
			}
		}
		else if(input.equals("2")) {
			//removeActivity()
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.print("Activity Name:");
			String aNamee = takeInput();
			int aNumber = Integer.parseInt(aNamee);
			
			System.out.println("/t<<<Remove Activity or Task Menu>>>");
			System.out.println("1-Activity\n2-Task\nq:to quit");
			input = takeInput();
			
			if(input.equals("1")) {
				removeActivity(pName, aNumber);
			}
			else if(input.equals("2")) {
				System.out.print("Task Number:");
				String tNumberr = takeInput();
				int tNumber = Integer.parseInt(tNumberr);
				
				removeTask(pName, aNumber, tNumber);
				//pName
			}
			else if(input.toLowerCase().equals("q")) {
				
			}
			else {
				
			}
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("Quit is selected");
		}
		else {
			System.out.println("Invalid");
		}

	}
	
	public void addActivity(String pName) {
		System.out.println("Project addActivity");
		
		System.out.print("Activity Description:");
		String aDescription = takeInput();
		
		System.out.print("Activity Start Date:");
		String aStartDate = takeInput();
		
		System.out.print("Activity Deliverable:");
		String aDeliverable = takeInput();
		
		
		int aNumber = getMediator().addActivity(pName,aDescription,aStartDate,aDeliverable);
		addTask(pName,aNumber);
		//signature not final
		//Each activity should have at least one task.
		
		
		
		//Mediator activity creation ???
		//addTask(pName, aName, tName, tDescription, tStartDate, tHours);
		//pName, aName add
		
	}
	
	public void removeActivity(String pName, int aNumber) {
		getMediator().removeActivity(pName, aNumber);
		//signature not final
		//System.out.println("Project removeActivity");
	}
	
	public void removeTask(String pName, int aNumber, int tNumber) {
		getMediator().removeTask(pName, aNumber,tNumber);
		//signature not final
		//System.out.println("Project removeTask");
	}
	
	public void updateResource() {
		//signature not final
		System.out.println("\t<<Update Project Resource Menu>>>");
		System.out.println("1-Add\n2-Remove\nq:to quit");
		String input = takeInput();
		
		if(input.equals("1")) {
			//add Resource to task
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.print("Activity Name:");
			String aName = takeInput();
			
			System.out.print("Task Name:");
			String tName = takeInput();
			
			System.out.print("Resource Id:");
			String rId = takeInput();
			
			addResource(pName, aName, tName, rId);
		}
		else if(input.equals("2")) {
			//remove Resource from task
			System.out.print("Project Name:");
			String pName = takeInput();
			
			System.out.print("Activity Name:");
			String aName = takeInput();
			
			System.out.print("Task Name:");
			String tName = takeInput();
			
			removeResource(pName, aName, tName);
			
		}
		else if(input.toLowerCase().equals("q")) {
			System.out.println("q is selected");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public void addTask(String pName, int aNumber) {
		
		System.out.print("Task Description:");
		String tDescription = takeInput();
		
		System.out.print("Task start date:");
		String tStartDate = takeInput();
		
		System.out.print("Task hour:");
		String tHourss = takeInput();
		int tHours = Integer.parseInt(tHourss);
		
		
		getMediator().addTask(pName,aNumber,tDescription,tStartDate,tHours);
		
		//addTask(pName,aNumber);
		//signature not final
		//Mediator Task creation for latest project latest activity ???
		//System.out.println("Project addTask");
	}
	
	public void addResource(String pName, String aName, String tName, String rId) {
		//signature not final
		System.out.println("Project addResource");
	}
	
	public void removeResource(String pName, String aName, String tName) {
		//signature not final
		System.out.println("Project removeResource");
	}
	
	public void projectCalculate(String pName) {
		System.out.println("projectCalculate");
		int result = getMediator().calculateProject(pName);
		System.out.println("Calculated Project:" + result);
		
	}
	
	public void activityCalculate(String pName, String aId) {
		System.out.println("activityCalculate");
		int result = getMediator().calculateActivity(pName, Integer.parseInt(aId));
		System.out.println("Calculated Activity:" + result);
	}
	
	public void taskCalculate(String pName, String aId, String tId) {
		System.out.println("taskCalculate");
		int result = getMediator().calculateTask(pName, Integer.parseInt(aId), Integer.parseInt(tId));
		System.out.println("Calculate Task:" + result);
	}
}
