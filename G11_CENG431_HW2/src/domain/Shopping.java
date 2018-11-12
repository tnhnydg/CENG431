package domain;

import java.io.IOException;
import java.time.LocalDate;

import dataAccess.DataHandler;
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
	
	public void placeOrder() throws IOException {
		DataHandler dataHandler = new DataHandler();
		store.setAllOrders(dataHandler.loadOrderList());
		System.out.println(store.getAllOrders().size() + "asdsa");
		
		ShoppingMenu shoppingMenu = createShoppingMenu();
		shoppingMenu.start();

		Order order = new Order();
	
		// Menu actions
		getCustomer().saveOrder(order);
		customer.setOrderWeight(10);
		order.doAction(customer, this.store);
	
		// Menu actions
		getCustomer().submitOrder(order);
		order.doAction(customer, this.store);
		
		// Menu actions
		getStore().chargeCustomer(order);
		order.doAction(customer, store);
		System.out.println(order.getOrderState() + "state");
		System.out.println(customer.getSavings() + "savings");
		
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
