import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		if(a.equals("A"))
			System.out.println("best!!!");
		else if(a.equals("B"))
			System.out.println("good!!");
		else if(a.equals("C"))
			System.out.println("run!");
		else if(a.equals("D"))
			System.out.println("slowly~");
		else
			System.out.println("what?");	
	}

}

