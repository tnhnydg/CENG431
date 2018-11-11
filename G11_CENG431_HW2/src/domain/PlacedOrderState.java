package domain;

import java.util.Random;

public class PlacedOrderState implements OrderState {

	
	public PlacedOrderState() {
		
	}
	
	@Override
	public void doAction(Order order, Customer customer, Store store) {
		calculateCargoPrice(createDeliveryDistance());
		calculateProductPrice(order);
	}
	
	public int createDeliveryDistance() {
		Random r = new Random();
		int low = 100;
		int high = 501;
		int result = r.nextInt(high-low) + low;
		return result;
	}
	
	public double calculateCargoPrice(int deliveryDistance) {
		return (0.53)*deliveryDistance;
	}
	
	public double calculateProductPrice(Order order) {
		return 55*order.getWeight();
	}
}
