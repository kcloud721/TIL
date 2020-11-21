import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b[] = a.split("\\.");
		System.out.printf("%s-%s-%s", b[2],b[1], b[0]);
	}

}

