package op;

public class Op1 {

	public static void main(String[] args) {
		int a = 10;
		a++;	// a += 1
		System.out.println(a);
		
		int x = 10, y = 10;
		int result = 0;
		result = ++x + ++y;
		System.out.printf("result: %d + %d = %d",  x, y, result);
	}

}
