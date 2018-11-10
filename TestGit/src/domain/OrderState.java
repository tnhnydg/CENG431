package domain;

public abstract class OrderState {

	public void doAction(Order order) {}
	public void doAction(Order order,Customer customer,double weight) {}	
}
