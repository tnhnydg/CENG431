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
		
	public void start() {
		System.out.println(takeInput());
		
		project.startManage();
		project.startDisplay();
		resource.startManage();
		resource.startDisplay();
		
		getScanner().close();
	}
	
}
