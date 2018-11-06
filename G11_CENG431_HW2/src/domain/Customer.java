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
	//Order attribute???
	
	public Customer() {
		
	}
	
	public void saveOrder() { //Order arg??? 
		//set state of an order saved
		//order.saveOrder()
	}
	
	public void submitOrder() { //Order arg???
		
	}
	
	public void cancelOrder() {//Order arg???
		
	}
	
	public void deleteOrder() {//Order arg???
		
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

}
