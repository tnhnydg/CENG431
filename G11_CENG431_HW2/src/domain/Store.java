package domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	
	private List<Order> allOrders;
	
	public Store() {
		this.allOrders = new ArrayList<Order>();
	}
	
	public void chargeCustomer(Order order,Customer customer) { 
		OrderState chargedOrderState = new ChargedOrderState();
		order.setOrderState(chargedOrderState);
		order.doAction(customer,this);
	}
	
	public void cancelPayment(Order order) {
		OrderState placedOrderState = new PlacedOrderState();
		order.setOrderState(placedOrderState);
	}
	
	public void shipOrder(Order order) {
		OrderState shippedOrderState = new ShippedOrderState();
		order.setOrderState(shippedOrderState);
		
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
