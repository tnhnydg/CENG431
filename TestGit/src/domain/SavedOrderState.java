package domain;

import java.util.Random;

public class SavedOrderState extends OrderState {
	
	
	public SavedOrderState() {
		
	}
	
	@Override
	public void doAction(Order order,Customer customer,double weight) {
		setOrderId(order,customer);
		setTrackingNumber(order);
		setCustomerIdNameAddress(order,customer);
		setWeight(order,weight);
		
	}
	
	public void setOrderId(Order order,Customer customer) {
		int lastOrderId = customer.getLastOrderId();
		order.setId(lastOrderId+1);
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
	
	public void setWeight(Order order,double weight) {
		order.setWeight(weight);
	}
	
	
}
