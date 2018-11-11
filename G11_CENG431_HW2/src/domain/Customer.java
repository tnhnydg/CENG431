package domain;

import java.util.List;

public class Customer {
	// Not final attributes changes are possible
	private int id;
	private String name;
	private String address;
	private double savings;
	private String phone;
	private String email;
	private String password;
	private List<Order> orderList;
	//Order attribute???
	
	public Customer() {
		
	}
	
	public void saveOrder(double weight) { 
		Order order = new Order();
		OrderState savedOrderState = new SavedOrderState();
		order.setOrderState(savedOrderState);
		addToOrderList(order);
		order.doAction(this,weight);
		
	}
	
	public void submitOrder(Order order) { 
		OrderState placedOrderState = new PlacedOrderState();
		order.setOrderState(placedOrderState);
		order.doAction();
		
	}
	
	public void cancelOrder() {
		
	}
	
	public void deleteOrder(Order order) {
		OrderState cancelledOrderState = new CancelledOrderState();
		order.setOrderState(cancelledOrderState);
	}
	
	public void addToOrderList(Order order) {
		this.orderList.add(order);
	}
	
	public int getLastOrderId() {
		return getOrderList().get(getOrderList().size()-1).getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
