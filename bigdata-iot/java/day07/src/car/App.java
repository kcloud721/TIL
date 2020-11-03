package car;

public class App {

	public static void main(String[] args) {
		//0x111
		Car c1 = new Car("k1", 1000);
		//0x222
		Car c2 = new Car("k1", 1000);
		System.out.println(c1);
		System.out.println(c2);
		c2.setSize(2000);
	}

}
