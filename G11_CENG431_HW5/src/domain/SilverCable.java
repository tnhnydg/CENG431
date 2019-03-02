package domain;

public class SilverCable extends CableDecorator {

	public SilverCable(Component component) {
		super(component);
		AddToCost();
	}
	
	public void AddToCost() {
		super.AddToCost(350);
	}
}
