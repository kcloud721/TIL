import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int power = 1;
		for(int i=0; i<b; i++) {
			power *= 2;
		}

		System.out.println(a * power);

	}

}

