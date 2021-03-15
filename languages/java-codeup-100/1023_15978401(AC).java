import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String[] data = a.split("[.]");
		System.out.println(data[0]);
		System.out.println(data[1]);
	}

}
