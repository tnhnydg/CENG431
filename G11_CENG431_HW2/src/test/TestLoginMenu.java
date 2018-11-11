package test;

import domain.Customer;
import presentation.*;

public class TestLoginMenu {

	public static void main(String[] args) {
		LoginMenu login = new LoginMenu();
		Customer customer = login.start();
		System.out.println(customer.getName());
		System.out.println(customer.getId());
		
		
	}

}
