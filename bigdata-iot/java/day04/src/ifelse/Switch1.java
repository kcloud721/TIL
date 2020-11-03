package ifelse;

import java.util.Random;

public class Switch1 {

	public static void main(String[] args) {
		Random r = new Random();
		int i = r.nextInt(8)+1;
		String item = "Prize: ";
		switch(i) {
		case 1: item += "phone"; break;
		case 2: item += "TV"; break;
		case 3: item += "pad"; break;
		case 4: item += "pod"; break;
		default: item += "Next..."; 
		}
		
		System.out.println(item);
	}

}
