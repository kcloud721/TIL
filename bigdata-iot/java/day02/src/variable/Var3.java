package variable;

public class Var3 {

	public static void main(String[] args) {
		int i = 10;
		String s = "Result";
		double d = 10.12365;
		
		System.out.println(s + i + " " + d);
		System.out.printf("Result: %d, %5.3f \n", i, d);
		System.out.printf("Result2: %x, %o", i, i); // %x : 16진수,  %o : 8진수
	}

}
