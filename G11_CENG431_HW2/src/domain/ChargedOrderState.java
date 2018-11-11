package domain;

public class ChargedOrderState implements OrderState {

	
	public ChargedOrderState() {
		
	}
	
	public void doAction(Order order,Customer customer,Store store) {
		setTotalPriceOfOrder(order);
		if(!isAffordable(order,customer)) {
			store.cancelPayment(order);
		}
	}
	
	public void setTotalPriceOfOrder(Order order) {
		double totalPrice = order.getCargoPrice() + order.getProductPrice();
		order.setTotalPrice(totalPrice);
		
	}
	
	public boolean isAffordable(Order order,Customer customer) {
		return customer.getSavings() >= order.getTotalPrice();
	}
}
