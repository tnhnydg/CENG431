package presentation;

import dataAccess.DataHandler;
import domain.*;

public class LoginMenu extends Menu {
	
	public LoginMenu() {
		
	}

	public Customer start() {
		System.out.println("1- Sign-in");
		System.out.println("2- Sign-up");
		String input = takeInput();
		
		if(input.equals("1"))
			return singIn();
		else if(input.equals("2"))
			return signUp();
		
		return null;
	}
	
	public Customer singIn() {
		System.out.print("E-mail:");
		String email = takeInput();
		
		System.out.print("Password:");
		String password = takeInput();
		
		DataHandler dataHandler = new DataHandler();
		return dataHandler.signInCustomer(email, password);
	}
	
	public Customer signUp() {
		Customer customer = new Customer();
		
		System.out.print("ID:");
		customer.setId(Integer.parseInt(takeInput()));
		
		System.out.print("Name:");
		customer.setName(takeInput());
		
		System.out.print("Address:");
		customer.setAddress(takeInput());
		
		System.out.print("Saving:");
		customer.setSavings(Integer.parseInt(takeInput()));
		
		System.out.print("Phone:");
		customer.setPhone(takeInput());
		
		System.out.print("E-mail:");
		customer.setEmail(takeInput());
		
		System.out.print("Password:");
		customer.setPassword(takeInput());
		
		DataHandler dataHandler = new DataHandler();
				
		return dataHandler.signUpCustomer(customer);

	}

}
