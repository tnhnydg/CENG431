package dataAccess;

import java.time.LocalDate;

public class OrderWrapper {
	private int id;
	private int trackingNumber;
	private int customerId;
	private String customerName;
	private double weight;
	private String shippingAddress;
	private String dateShipped = LocalDate.now().toString();
	private String dateDelivered = LocalDate.now().toString();
	private double productPrice;
	private double cargoPrice;
	private double totalPrice;
	
	public OrderWrapper(int id, int trackingNumber, int customerId, String customerName, double weight, String shippingAddress, LocalDate dateShipped, LocalDate dateDelivered, double productPrice, double cargoPrice, double totalPrice) {
		setId(id);
		setTrackingNumber(trackingNumber);
		setCustomerId(customerId);
		setCustomerName(customerName);
		setWeight(weight);
		setShippingAddress(shippingAddress);
		setDateShipped(dateShipped);
		setDateDelivered(dateDelivered);
		setProductPrice(productPrice);
		setCargoPrice(cargoPrice);
		setTotalPrice(totalPrice);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(int trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public LocalDate getDateShipped() {
		String date[] = this.dateShipped.split("-");
		System.out.println(date[0] + date[1] + date[2]);
		return LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
	}

	public void setDateShipped(LocalDate dateShipped) {
		this.dateShipped = dateShipped.toString();
	}

	public LocalDate getDateDelivered() {
		String date[] = this.dateDelivered.split("-");
		System.out.println(date[0] + date[1] + date[2]);
		return LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
	}

	public void setDateDelivered(LocalDate dateDelivered) {
		this.dateDelivered = dateDelivered.toString();
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
