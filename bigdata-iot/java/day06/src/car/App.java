package car;

public class App {

	public static void main(String[] args) {
		Car c1 = new Car("K1", "red", 80, 15.7);
		System.out.println(c1.toString());
		int gas = c1.getGas(); //기름 얼마나 남았지?
		System.out.println("Gas Level: " + gas);
		
		c1.addGas(30);
		System.out.println(c1.toString());
		c1.go(20.0);
		c1.stop();
		System.out.println(c1.toString());
	}

}
