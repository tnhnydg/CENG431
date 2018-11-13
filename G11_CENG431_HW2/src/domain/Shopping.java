package domain;

import java.io.IOException;
import java.time.LocalDate;

import dataAccess.DataHandler;
import presentation.*;

public class Shopping {
	
	private ShoppingMenu shoppingMenu;
	private Customer customer;
	private Store store;
	private Order order;
	
	public Shopping(Store store, Customer customer) {
		setStore(store);
		setCustomer(customer);
		setShoppingMenu(createShoppingMenu());
		setOrder(new Order());
	}
	
	public void placeOrder() throws IOException {
		
		loadOrderList();
		getShoppingMenu().start();
		getCustomer().saveOrder(getOrder());
		takeDate();
		takeWeight();
		
		while(!(getOrder().getOrderState() instanceof DeliveredOrderState)) {
			if(getOrder().getOrderState() instanceof SavedOrderState) 
				askForCancelation();
			else if(getOrder().getOrderState() instanceof PlacedOrderState)
				askForCancelation();
			else if(getOrder().getOrderState() instanceof ChargedOrderState)
				askForCancelation();
			else if(getOrder().getOrderState() instanceof CancelledOrderState)
				break;
			
			doAction();
	    }
		doAction();
	}
	
	public void setShoppingMenu(ShoppingMenu shoppingmenu) {
		this.shoppingMenu = shoppingmenu;
	}
	
	public ShoppingMenu getShoppingMenu() {
		return this.shoppingMenu;
	}
	
	public ShoppingMenu createShoppingMenu() {
		return new ShoppingMenu();
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	private Order getOrder() {
		return this.order;
	}
	
	public Order createOrder() {
		return new Order();
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
	
	public void askForCancelation() {
		String input = shoppingMenu.askFor("Do you want to cancel order (y/n)");
		if(input.toLowerCase().equals("y")) {
			getCustomer().deleteOrder(order);
		}
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
	
	public void takeDate() {
		String input = getShoppingMenu().askFor("Please enter the current date(YYYY-MM-DD) ");
		String[] parts = input.split("-");
		LocalDate currentdate = LocalDate.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
		getCustomer().setCurrentDate(currentdate);
	}
	
	public void takeWeight() {
		String input = getShoppingMenu().askFor("Please enter the weight ");
		getCustomer().setOrderWeight(Double.parseDouble(input));
	}
	
	public void loadOrderList() throws IOException {
		DataHandler dataHandler = new DataHandler();
		store.setAllOrders(dataHandler.loadOrderList());
	}
	
	public void doAction() {
		getOrder().doAction(getCustomer(), getStore());
		updateCustomerFile(getCustomer());
	}

}
