package domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dataAccess.Data;
import presentation.MainMenu;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Starting the program...");
		IProjectPortfolioManager mediator = new ProjectPortfolioManager();
		
		Data data = new Data();
		//data.testWriteJSON();
		//data.myTry();
		//data.template();
		List<Task> taskList =new ArrayList<Task>();
		Task tsk = new Task("desc","startDate",2);
		taskList.add(tsk);
		Task tsk2 = new Task("desc","startDate",2);
		taskList.add(tsk);
		Task tsk3 = new Task("desc","startDate",2);
		taskList.add(tsk);
		Task tsk4 = new Task("desc","startDate",2);
		taskList.add(tsk);
		
		List<Activity> activityList = new ArrayList<Activity>();
		Activity act = new Activity(5, "desc", "1.1.1", "deliv");
		act.setTaskList(taskList);
		activityList.add(act);
		activityList.add(act);
		activityList.add(act);
		activityList.add(act);
		activityList.add(act);
		
		List<Project> projectList = new ArrayList<Project>();
		Project prj = new Project("pName", "descr", "1.23.13");
		prj.setActivityList(activityList);
		
		projectList.add(prj);
		projectList.add(prj);
		projectList.add(prj);
		projectList.add(prj);
		projectList.add(prj);
		projectList.add(prj);
		
		String datam = data.saveProjects(projectList);
		
		System.out.println(datam);
		data.writeFile("", datam);
	
		List<Project> a = data.loadProjects(data.readFile(""));
		System.out.println(a);
		
	//	System.out.println(data.buildActivitys(activityList));
		
		MainMenu menu = new MainMenu(mediator);
		menu.start();
		
		
	}
	

}
