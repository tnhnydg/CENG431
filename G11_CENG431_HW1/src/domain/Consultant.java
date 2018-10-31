package domain;

import java.util.Random;

public class Consultant extends Person {
	
	public Consultant(String cName, String cDescription) {
		super(cName, cDescription);
		setId(generateId());
	}
	
	public Consultant(String cName, String cDescription, int rId) {
		super(cName, cDescription);
		setId(rId);
	}
	
	@Override
	public int generateId() {
		Random r = new Random();
		int low = 20000;
		int high = 29999;
		int result = r.nextInt(high-low) + low;
		
		return result;
	}
	
	public String toString() {
		return "Consultant: " + super.toString();
	}
}