import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		
		String date[] = a.split(":");
		System.out.print(date[0]+":"+date[1]);
		
	}

}

