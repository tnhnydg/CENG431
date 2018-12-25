package domain;

public class CancelledOrderState implements OrderState{
	
	public CancelledOrderState() {
		
	}

	@Override
	public void doAction(Order order, Customer customer, Store store) {
		System.out.println("Cancelled");
	}

	
}