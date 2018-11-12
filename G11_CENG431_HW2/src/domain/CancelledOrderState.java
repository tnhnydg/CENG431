package domain;

public class CancelledOrderState implements OrderState{
	
	public CancelledOrderState() {
		
	}

	@Override
	public void doAction(Order order, Customer customer, Store store) {
		// TODO Auto-generated method stub
		System.out.println("cancelled");
	}

	
}