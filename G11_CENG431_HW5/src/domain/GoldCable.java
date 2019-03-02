package domain;

public class GoldCable extends CableDecorator {

	public GoldCable(Component component) {
		super(component);
		AddToCost();
	}
	
	public void AddToCost() {
		super.AddToCost(500);
	}
}
