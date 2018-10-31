package domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dataAccess.DataHandler;
import presentation.MainMenu;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Starting the program...");
		IProjectPortfolioManager mediator = new ProjectPortfolioManager();
		
		mediator.start();

	}
	

}
