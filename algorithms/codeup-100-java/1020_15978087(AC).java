import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String num[] = a.split("-");
		System.out.println(num[0]+num[1]);
	}
	
}

