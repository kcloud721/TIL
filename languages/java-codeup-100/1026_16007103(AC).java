import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b[] = a.split(":");
		if(b[1].equals("00"))
			System.out.print("0");
		else
			System.out.print(b[1]);
	}

}

