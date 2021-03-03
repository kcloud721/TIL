import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String[] data = a.split("");
		for(int i=0; i<data.length; i++) {
			System.out.println("'" + data[i] + "'");

		}
	}
	
}

