package variable;

public class Var2 {

	public static void main(String[] args) {
		// Primitive type
		// 1. boolean
		boolean v1 = true;
		// 2. integer
		byte b1 = 127;
		byte b2 = 127;
		byte b3 = (byte)(b1+b2); //잘라버려
		System.out.println(b3);
		
		int v2 = 10;
		long v3 = 10L;
		// 3. character
		char v4 = 'A';
		// 4. double
		double v5 = 10.1;
		float  v6 = 10.1f;
		
		//Reference Type
		String v7 = "ABC DEF";
	}

}
