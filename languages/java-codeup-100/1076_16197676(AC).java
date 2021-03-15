import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char in = sc.next().charAt(0);
		
		for(int i=97; i<=(int) in; i++) {
			System.out.println((char) i);
		}
		
	}

}

