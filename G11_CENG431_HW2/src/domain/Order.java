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
	
	
	public Order() {

	}


	@Override
	public void saveOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void submitOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void chargeCustomer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void shipOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deliverOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void cancelOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void cancelPayment() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void error() {
		// TODO Auto-generated method stub
		
	}
}
