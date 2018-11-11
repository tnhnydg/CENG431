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
			
		}
	}
	
	public int generateShippingDuration() {
		Random r = new Random();
		int low = 1;
		int high = 10; // it may be 11, check
		int result = r.nextInt(high-low) + low;
		return result;
	}
	
}
