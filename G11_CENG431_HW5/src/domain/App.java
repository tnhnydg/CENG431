package domain;


public class App {

	public static void main(String[] args) {
		
		System.out.println("-------------Computer Comparison Menu-------------\n");
		
		Computer acer = new Computer(new RegularComputerFactory());
		System.out.println(acer);
		
		Computer monster = new Computer(new GamingComputerFactory());
		Component cable = new GoldCable(monster); // Note that, here 500TL is added to the cost.
		System.out.println(monster);


	}

}
