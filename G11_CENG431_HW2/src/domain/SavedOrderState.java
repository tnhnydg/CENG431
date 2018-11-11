package domain;

import java.util.Random;

public class SavedOrderState implements OrderState {

	
	public SavedOrderState() {
		
	}

	public void doAction(Order order,Customer customer, Store store) {
		setOrderId(order,customer);

		setTrackingNumber(order);
		setCustomerIdNameAddress(order,customer);

		setWeight(order,customer);

		//setWeight(order,weight);

		
	}
	

	public void setOrderId(Order order,Customer customer,Store store) { 
		int lastOrderId = store.getAllOrders().get(store.getAllOrders().size()-1).getId();
		order.setId(lastOrderId+1);
	}

	public void setOrderId(Order order,Customer customer) {
		

	}
	
	public void setTrackingNumber(Order order) {
		Random r = new Random();
		int low = 100000;
		int high = 999999;
		int result = r.nextInt(high-low) + low;
		order.setTrackingNumber(result);
	}
	
	public void setCustomerIdNameAddress(Order order,Customer customer) {
		int customerId = customer.getId();
		String customerName = customer.getName();
		String shippingAddress = customer.getAddress();
		order.setCustomerId(customerId);
		order.setCustomerName(customerName);
		order.setShippingAddress(shippingAddress);
	}
	
	public void setWeight(Order order,Customer customer) {
		double w = customer.getOrderWeight();
		order.setWeight(w);
	}
	
	
}
