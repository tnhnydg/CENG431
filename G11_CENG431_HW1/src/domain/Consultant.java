package domain;

import java.util.List;

public class Consultant extends Person {
	
	public Consultant(String cName, String cDescription) {
		super(cName, cDescription);
		//generateId()
	}
	
	public Consultant(String cName, String cDescription, int rId) {
		super(cName, cDescription);
		setId(rId);
	}
	
	@Override
	public int generateId() {
		return 0;
	}
}
