package domain;

public interface OrderState {
	//Not final interface open for discussions
	public void saveOrder();
	public void submitOrder();
	public void chargeCustomer();
	public void shipOrder();
	public void deliverOrder();
	public void deleteOrder();
	public void cancelOrder();
	public void cancelPayment();
	public void error();
	
}
