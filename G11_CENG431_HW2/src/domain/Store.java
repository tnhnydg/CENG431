package domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	
	private List<Order> allOrders;
	
	public Store() {
		this.allOrders = new ArrayList<Order>();
	}
	
	public Shopping createShopping() {
		return new Shopping(this);
	}
	
	public void chargeCustomer(Order order) { //Customer param???
		order.setOrderState(new ChargedOrderState());
		
	}
	
	public void cancelPayment(Order order) { //Customer param???
 		order.setOrderState(new PlacedOrderState());
	}
	
	public void shipOrder(Order order) {
		order.setOrderState(new ShippedOrderState());
	}
	
	public void deliverOrder(Order order) {
		order.setOrderState(new DeliveredOrderState());
	}

	public List<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(List<Order> allOrders) {
		this.allOrders = allOrders;
	}

}
