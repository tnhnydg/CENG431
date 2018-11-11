package test;

import domain.*;
import presentation.LoginMenu;
import dataAccess.*;

public class TestApp {

	public static void main(String[] args) {
		Store store = new Store();
		
		//Starting menu works and at the end return a customer
		//Lastly ask "Do you want to place an Order" if yes placeOrder and quit starting menu
		//if no quit starting menu
		LoginMenu loginMenu = new LoginMenu();
		Customer customer = loginMenu.start();
		System.out.println(customer.getName());
		 		
		Shopping shopping = store.createShopping();
		shopping.placeOrder(customer);
		
	}

}
