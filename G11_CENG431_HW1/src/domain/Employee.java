package domain;

import java.util.Random;

public class Employee extends Person {

	public Employee(String eName, String eDescription) {
		super(eName, eDescription);
		setId(generateId());
	}
	
	public Employee(String eName, String eDescription, int rId) {
		super(eName, eDescription);
		setId(rId);
	}
	
	@Override
	public int generateId() {
		Random r = new Random();
		int low = 10000;
		int high = 19999;
		int result = r.nextInt(high-low) + low;
		return result;
	}
	
	@Override 
	public String toString() {
		return "Employee: " + super.toString();
	}

}
