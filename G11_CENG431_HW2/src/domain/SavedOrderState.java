package domain;

import java.util.Random;



public class SavedOrderState implements OrderState {

	
	public SavedOrderState() {
		
	}

	public void doAction(Order order,Customer customer, Store store) {
		System.out.println("doAction : SavedOrderState");
		setOrderId(order,store);
		setTrackingNumber(order);
		setCustomerIdNameAddress(order,customer);
		setWeight(order,customer);
	
		customer.submitOrder(order);
	}
	
	public void setOrderId(Order order,Store store) { 
		if(store.getAllOrders().size() == 0) {
			order.setId(1);
			store.getAllOrders().add(order);
		}
		else {
			int lastOrderId = store.getAllOrders().get(store.getAllOrders().size()-1).getId();
			order.setId(lastOrderId+1);
			store.getAllOrders().add(order);
		}
		
	}
	
	public void setTrackingNumber(Order order) {
		Random r = new Random();
		int low = 100000;
		int high = 1000000;
		int result = r.nextInt(high-low) + low;
		order.setTrackingNumber(result);
	}
	
	public void setCustomerIdNameAddress(Order order,Customer customer) {
		order.setCustomerId(customer.getId());
		order.setCustomerName(customer.getName());
		order.setShippingAddress(customer.getAddress());
	}
	
	public void setWeight(Order order,Customer customer) {
		double w = customer.getOrderWeight();
		order.setWeight(w);
	}
	
	
}
