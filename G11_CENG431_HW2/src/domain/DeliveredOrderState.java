package domain;

import java.io.IOException;
import java.util.Random;

import dataAccess.DataHandler;

public class DeliveredOrderState implements OrderState {

	
	public DeliveredOrderState() {
		
	}
	@Override
	public void doAction(Order order, Customer customer, Store store) {
		int plannedDeliveryDuration = generateDeliveryDuration();
		int realDeliveryDuration = generateDeliveryDuration();
		System.out.println("rdd : " + realDeliveryDuration + " pdd : " + plannedDeliveryDuration);
		if(realDeliveryDuration - plannedDeliveryDuration > 8) {
			System.out.println("Error: Lost in shipping.");
			order.setOrderState(new ChargedOrderState());
			customer.setSavings(customer.getSavings()+order.getTotalPrice());//repayment
		}
		else {
			order.setDateDelivered(customer.getCurrentDate().plusDays(realDeliveryDuration));
			try {
				saveState(store);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int generateDeliveryDuration() {
		Random r = new Random();
		int low = 3;
		int high = 13;
		int result = r.nextInt(high-low) + low;
		return result;
	}
	
	public void saveState(Store store) throws IOException {
		DataHandler dataHandler = new DataHandler();
		dataHandler.saveOrderList(store.getAllOrders());
	}
}
