package domain;

import java.util.Scanner;

import presentation.MainMenu;

public class App {

	public static void main(String[] args) {
		System.out.println("Starting the program...");
		IProjectPortfolioManager mediator = new ProjectPortfolioManager();
		
		MainMenu menu = new MainMenu(mediator);
		menu.start();
	}
	

}
