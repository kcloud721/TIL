import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		if(b >= a) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}

