package ifelse3;

import java.util.Random;

public class If3 {

	public static void main(String[] args) {
		Random r = new Random();
		int num1 = r.nextInt(10)+1;
		int num2 = r.nextInt(10)+1;
		int num3 = r.nextInt(10)+1;
		System.out.println(num1 + " " + num2 + " " + num3);
		int max = 0;
		int min = 0;
		
		num1 = 3; num2 = 2; num3 = 3;
		
		if(num1 > num2) {
			if (num1 > num3)
				max = num1;
			else
				max = num3;
		} else{
			if (num2 > num3)
				max = num2;
			else
				max = num3;
		}

		if(num1 < num2) {
			if (num1 < num3)
				min = num1;
			else
				min = num3;
		} else{
			if (num2 < num3)
				min = num2;
			else
				min = num3;
		}

		System.out.println("max: " + max);
		System.out.println("min: " + min);
		
		//3Ç×
		max = (num1 > num2) ? 
				((num1 > num3) ? num1 : num3) :
					((num2 > num3) ? num2 : num3);

		
		

	}

}
