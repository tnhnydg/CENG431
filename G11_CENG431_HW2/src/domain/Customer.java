package domain;

public class Customer {
	// Not final attributes changes are possible
	private int id;
	private String name;
	private String address;
	private double savings;
	private String phone;
	private String email;
	private String password;
	private double orderWeight;
	private Order order;
	//Order attribute???
	
	public Customer() {
		
	}

	public void saveOrder(Store store) { 
		Order order = new Order();
		OrderState savedOrderState = new SavedOrderState();
		order.setOrderState(savedOrderState);
		setOrder(order);
		order.doAction(this,store);
	}
		

	public Order saveOrder(Order order) { 
		order.setOrderState(new SavedOrderState());
		return order;

	}
	
	public void submitOrder(Order order) { 

		OrderState placedOrderState = new PlacedOrderState();
		order.setOrderState(placedOrderState);
		order.doAction(this,new Store());
		order.setOrderState(new PlacedOrderState());		

	}
	
	public void cancelOrder(Order order) {
		order.setOrderState(new CancelledOrderState());
	}
	
	public void deleteOrder(Order order) {

		OrderState cancelledOrderState = new CancelledOrderState();
		order.setOrderState(cancelledOrderState);

		order.setOrderState(new CancelledOrderState());

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


	public double getOrderWeight() {
		return orderWeight;
	}

	public void setOrderWeight(double orderWeight) {
		this.orderWeight = orderWeight;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
