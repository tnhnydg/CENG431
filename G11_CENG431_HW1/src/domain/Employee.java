package domain;


public class Employee extends Person {

	public Employee(String eName, String eDescription) {
		super(eName, eDescription);
		//generateId
		//setId
	}
	
	public Employee(String eName, String eDescription, int rId) {
		super(eName, eDescription);
		setId(rId);
	}
	
	@Override
	public int generateId() {
		return 0;
	}

	
}
