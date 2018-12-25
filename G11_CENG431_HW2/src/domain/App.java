package domain;

import java.io.IOException;

import presentation.LoginMenu;

public class App {

	public static void main(String[] args) throws IOException {
		// If file problem occurs customers.json and orders.json should have "[]" in it no quotes included.
		
		Store store = new Store();
	
		LoginMenu loginMenu = new LoginMenu();
		Customer customer = loginMenu.start();
		System.out.println(customer.getName());
		 		
		Shopping shopping = new Shopping(store, customer);
		shopping.placeOrder();
		
		
	}

}
