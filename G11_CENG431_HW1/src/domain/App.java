package domain;

import java.util.Scanner;

import presentation.MainMenu;

public class App {

	public static void main(String[] args) {
		System.out.println("Starting the program...");
		
		MainMenu menu = new MainMenu(null);
		menu.start();
	}
	

}
