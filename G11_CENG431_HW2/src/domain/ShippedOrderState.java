package domain;


import java.util.Random;


public class ShippedOrderState implements OrderState {

	public ShippedOrderState() {
		
	}
	
	@Override
	public void doAction(Order order,Customer customer,Store store) {
		int plannedShippingDuration = generateShippingDuration();
		int realShippingDuration = generateShippingDuration();
		if(realShippingDuration - plannedShippingDuration > 7) {
			System.out.println("Error: Not shipped.");
			order.setOrderState(new ChargedOrderState());
			customer.setSavings(customer.getSavings()+order.getTotalPrice());//repayment
		}
		else {
			order.setDateShipped(customer.getCurrentDate().plusDays(realShippingDuration));
		}
	}
	
	public int generateShippingDuration() {
		Random r = new Random();
		int low = 1;
		int high = 11;
		int result = r.nextInt(high-low) + low;
		return result;
	}
	
}
