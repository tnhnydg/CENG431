package domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	
	private List<Order> allOrders;
	
	public Store() {
		this.allOrders = new ArrayList<Order>();
	}
	
	public void chargeCustomer() { //Customer param???
		//Customer.pay(double value) ???
	}
	
	public void cancelPayment() { //Customer param???
 		
	}
	
	public void shipOrder() {
		
	}
	
	public void deliverOrder() {
		
	}

	public List<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(List<Order> allOrders) {
		this.allOrders = allOrders;
	}

}
