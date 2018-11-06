package domain;

import java.time.LocalDate;

public class Order implements OrderState {
	
	private int id;
	private int trackingNumber; // String ??
	private int customerId;
	private String customerName;
	private double weight;
	private String shippingAddress;
	private LocalDate dateShippied;
	private LocalDate dateDelivered;
	private double productPrice;
	private double cargoPrice;
	private double totalPrice;
	private OrderState state;
	
	
	public Order(OrderState state) {
		setOrderState(state);
	}
	
	public void setOrderState(OrderState state) {
		this.state = state;
	}
	
	public OrderState getOrderState() {
		return this.state;
	}

	@Override
	public void saveOrder() {
		state.saveOrder();
	}

	@Override
	public void submitOrder() {
		state.submitOrder();
	}
	
	@Override
	public void chargeCustomer() {
		state.chargeCustomer();
	}


	@Override
	public void shipOrder() {
		state.shipOrder();
	}

	@Override
	public void deliverOrder() {
		state.deliverOrder();
	}


	@Override
	public void deleteOrder() {
		state.deleteOrder();
	}


	@Override
	public void cancelOrder() {
		state.cancelOrder();
	}


	@Override
	public void cancelPayment() {
		state.cancelPayment();
	}

	@Override
	public void error() {
		state.error();
	}
}
