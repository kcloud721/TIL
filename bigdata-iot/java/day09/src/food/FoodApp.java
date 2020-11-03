package food;

public class FoodApp {
	public static void main(String[] args) {
		Hamburger h = new Hamburger(1000, 500, "f", 50);
		System.out.println(h);
		h.drinkBeer();
		
		Hamburger h2 = new Hamburger(2000, 200, "f");
		System.out.println(h2);
		
	}

}
