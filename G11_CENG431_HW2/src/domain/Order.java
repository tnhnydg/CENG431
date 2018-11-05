package domain;

import java.time.LocalDate;

public class Order {
	
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
}
