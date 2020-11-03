package ex;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input number");
		int i = Integer.parseInt(s.nextLine()); 
		int a = 10;
		int result = 0;
		try {
			result = a/i;
		} catch(ArithmeticException e) {
			System.out.println("/ by zero.. try again");
			return;
		}
		System.out.println(result);
		
	}

}
