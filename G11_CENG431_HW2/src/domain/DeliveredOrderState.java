package domain;

import java.util.Random;

public class DeliveredOrderState implements OrderState {

	
	public DeliveredOrderState() {
		
	}
	@Override
	public void doAction(Order order, Customer customer, Store store) {
		int plannedDeliveryDuration = generateDeliveryDuration();
		int realDeliveryDuration = generateDeliveryDuration();
		if(realDeliveryDuration - plannedDeliveryDuration > 8) {
			System.out.println("Error: Lost in shipping.");
			order.setOrderState(new ChargedOrderState());
			customer.setSavings(customer.getSavings()+order.getTotalPrice());//repayment
		}
		else {
			order.setDateDelivered(customer.getCurrentDate().plusDays(realDeliveryDuration));
		}
	}
	
	public int generateDeliveryDuration() {
		Random r = new Random();
		int low = 3;
		int high = 13;
		int result = r.nextInt(high-low) + low;
		return result;
	}
}
