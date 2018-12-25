package domain;

import java.util.List;

public class Composite implements Component{
	
	private List<Component> componentList;
	
	public Composite() {
		
	}

	public List<Component> getComponentList() {
		return componentList;
	}

	public void setComponentList(List<Component> componentList) {
		this.componentList = componentList;
	}

}
