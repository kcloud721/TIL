import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		int result = 0;
		for(int i=1; i<=in; i++) {
			if(i%2 == 0)
				result += i;
		}
		System.out.println(result);
	}

}

