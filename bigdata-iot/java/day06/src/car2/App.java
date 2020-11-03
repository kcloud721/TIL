package car2;

public class App {

	public static void main(String[] args) {
		Car c1 = new Car("K1", 100, 10.0);
		System.out.println(c1.toString());
		
		c1.addGas(100);
		System.out.println(c1.toString());
		
		c1.go("Gwangju"); // Busan, Sokcho, Gwangju
		System.out.println(c1.toString());
		
		System.out.println("Gas Level: " + c1.gas);
		System.out.println("Current Location: " + c1.location);
		
		int total = c1.getTotal();
		System.out.println("Total Cost(tollgate + gas): " + total);
		
	}
}
