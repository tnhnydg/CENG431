package domain;

public class DeliveredOrderState implements OrderState {

	Order order;
	
	public DeliveredOrderState(Order order) {
		
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return this.order;
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
