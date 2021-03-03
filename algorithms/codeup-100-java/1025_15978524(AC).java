import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b[] = a.split("");
		for(int i=0; i<b.length; i++) {
			System.out.print("["+b[i]);
			for(int j=0; j<b.length-i-1; j++) {
				System.out.print("0");
			}
			System.out.println("]");
		}
	}

}

