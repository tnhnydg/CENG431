package presentation;

import java.util.Scanner;

public abstract class Menu {
	
	private Scanner input;
	
	public Menu() {
		setScanner(new Scanner(System.in));
	}
	

	public void setScanner(Scanner input) {
		this.input = input;
	}
	
	public Scanner getScanner() {
		return this.input;
	}
	
	public String takeInput() {
		String line = getScanner().nextLine();
		return line;
	}

}
