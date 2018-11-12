package presentation;

public class ShoppingMenu extends Menu{

	public ShoppingMenu() {
		
	}

	public void start() {
		System.out.println("Shopping Menu");
	}
	
	public String askFor(String message) {
		System.out.print(message + ":");
		String input = takeInput();
		return input;
	}
	

}
