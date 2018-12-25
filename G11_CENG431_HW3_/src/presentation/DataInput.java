package presentation;

import java.util.Scanner;

public class DataInput {
	
	private Scanner input;
	
	public DataInput() {
		setScanner(new Scanner(System.in));
	}
	
	public void setScanner(Scanner input) {
		this.input = input;
	}
	
	public Scanner getScanner() {
		return this.input;
	}
	
	public String takeInput(String message) {
		System.out.println(message);
		String line = getScanner().nextLine();
		return line;
		
	}
}
