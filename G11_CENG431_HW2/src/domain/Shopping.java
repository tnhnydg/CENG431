package domain;

import presentation.*;

public class Shopping {
	
	private Menu menu;
	private Customer customer;
	private Store store;
	
	public Shopping(Store store) {
		setStore(store);
	}
	
	public void placeOrder(Customer customer) {
		setCustomer(customer);
		//Menu menu = new Menu(); // Shopping Menu
		
		Order order = new Order();
		
		// Menu actions
		getCustomer().saveOrder(order);
		order.doAction(customer, this.store);
		
		// Menu actions
		getCustomer().submitOrder(order);
		order.doAction(customer, this.store);
		
		// Menu actions
		getStore().chargeCustomer(order);
		order.doAction(customer, store);
		
		// Menu actions
		getStore().shipOrder(order);
		order.doAction(customer, store);
		
		//Menu actions
		getStore().deliverOrder(order);
		order.doAction(customer, store);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
