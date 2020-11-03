package ifelse;

import java.util.Random;

public class If1 {
	
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(20)+1;
		if(num < 5) {
			System.out.println("Small Number ..." + num);
			return;			
		}
		if(num < 10) {
			System.out.println("Small Number ..." + num);
			return;			
		}
		System.out.println("Program Start ...");
		System.out.println("Result: " + num);
		System.out.println("Program End ...");
	}

}
