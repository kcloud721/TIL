import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String in = sc.next();
			System.out.println(in);
			if(in.equals("q"))
				return;
		}
		
	}

}

