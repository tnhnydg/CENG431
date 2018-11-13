package domain;

import java.io.IOException;

import dataAccess.DataHandler;

public class ChargedOrderState implements OrderState {

	
	public ChargedOrderState() {
		
	}
	
	public void doAction(Order order,Customer customer,Store store) {
		setTotalPriceOfOrder(order);
		System.out.println(order.getTotalPrice());
		if(!isAffordable(order,customer)) {
			store.cancelPayment(order);
		}
		else {
			customer.setSavings(customer.getSavings()-order.getTotalPrice());
			
			updateCustomerFile(customer);
			
			store.shipOrder(order);
		}
	}
	
	public void setTotalPriceOfOrder(Order order) {
		double totalPrice = order.getCargoPrice() + order.getProductPrice();
		order.setTotalPrice(totalPrice);
		
	}
	
	public boolean isAffordable(Order order,Customer customer) {
		return customer.getSavings() >= order.getTotalPrice();
	}
	
	public void updateCustomerFile(Customer customer) {
		DataHandler dataHandler = new DataHandler();
		try {
			dataHandler.jsonUpdateCustomer(customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
