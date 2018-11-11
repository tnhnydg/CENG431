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
		//Menu menu = new Menu(); // Shopping Menu
		
		Order order = new Order();
		
		// Menu actions
		customer.saveOrder(order);
		order.doAction(customer, store);
		
		// Menu actions
		customer.submitOrder(order);
		order.doAction(customer, store);
		
		// Menu actions
		store.chargeCustomer(order);
		//chargeCustomer();//Update savings of customer///Moved inside doaction
		order.doAction(customer, store);
		
		// Menu actions
		store.shipOrder(order);
		order.doAction(customer, store);
		
		//Menu actions
		store.deliverOrder(order);
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
