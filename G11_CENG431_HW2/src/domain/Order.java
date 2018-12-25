package domain;

import java.time.LocalDate;

public class Order {
	
	private int id;
	private int trackingNumber; 
	private int customerId;
	private String customerName;
	private double weight;
	private String shippingAddress;
	private LocalDate dateShipped;
	private LocalDate dateDelivered;
	private double productPrice;
	private double cargoPrice;
	private double totalPrice;
	private OrderState state;
	
	
	public Order() {
		initializeState();
	}
	
	public void initializeState() {
		this.state = null;
	}
	public void doAction(Customer customer, Store store) {
		state.doAction(this, customer, store);
	}
	
	public void setOrderState(OrderState state) {
		this.state = state;
	}
	
	public OrderState getOrderState() {
		return this.state;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTrackingNumber(int trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	public int getTrackingNumber() {
		return this.trackingNumber;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getShippingAddress() {
		return this.shippingAddress;
	}
	
	public void setDateShipped(LocalDate dateShipped) {
		this.dateShipped = dateShipped;
	}
	
	public LocalDate getDateShipped() {
		return this.dateShipped;
	}
	
	public void setDateDelivered(LocalDate dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	
	public LocalDate getDateDelivered() {
		return this.dateDelivered;
	}
	
	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getCargoPrice() {
		return cargoPrice;
	}

	public void setCargoPrice(double cargoPrice) {
		this.cargoPrice = cargoPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
