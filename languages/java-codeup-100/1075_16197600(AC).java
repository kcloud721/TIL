import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		while(true) {
			in --;
			System.out.println(in);
			if(in == 0)
				return;
		}
		
	}

}

