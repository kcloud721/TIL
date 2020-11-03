package scanner;

import java.util.Scanner;

public class sc1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Start ....");
		System.out.println("Input Number 1 .. ?");
		String s1 = sc.nextLine();
		System.out.println("Input Number 2 .. ?");
		String s2 = sc.nextLine();

		int result = 0;
		try {
			result = Integer.parseInt(s1) + Integer.parseInt(s2);
		} catch(Exception e) { //
			System.out.println("Invalid Number Format");
			sc.close();
			return;
		}
		System.out.println("Result: " +result);
		sc.close();
		System.out.println("End ....");
	}

}
