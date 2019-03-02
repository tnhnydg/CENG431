package domain;

public abstract class CableDecorator implements Component {
	private Component component;
	
	public CableDecorator(Component component) {
		setComponent(component);
	}

	public void AddToCost(int value) {
		component.AddToCost(value);
	}
	
	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}
}
