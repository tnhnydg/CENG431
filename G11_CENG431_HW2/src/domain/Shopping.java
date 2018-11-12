package domain;

import java.time.LocalDate;

import presentation.*;

public class Shopping {

	private Customer customer;
	private Store store;
	private Order order;
	
	public Shopping(Store store, Customer customer) {
		setStore(store);
		setCustomer(customer);
	}
	public ShoppingMenu createShoppingMenu() {
		return new ShoppingMenu();
	}
	
	public Order createOrder() {
		return new Order();
	}
	
	public void placeOrder() {
		ShoppingMenu shoppingMenu = createShoppingMenu();
		shoppingMenu.start();
		
		Order order = createOrder();
	
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
