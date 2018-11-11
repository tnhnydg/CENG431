package test;

import domain.*;
import dataAccess.*;

public class TestApp {

	public static void main(String[] args) {
		Store store = new Store();
		
		//Starting menu works and at the end return a customer
		//Lastly ask "Do you want to place an Order" if yes placeOrder and quit starting menu
		//if no quit starting menu
		 
		Customer customer = new Customer();
		
		Shopping shopping = store.createShopping();
		shopping.placeOrder(customer);
		
		
	}

}
