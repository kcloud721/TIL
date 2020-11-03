package op;

public class Op5 {

	public static void main(String[] args) {
//		char c = '1';
//		System.out.println(c);
//		boolean result = (('0' <= c) && (c <= '9'));
//		System.out.println(result);
		
		char c = '1';
		//char형이 알파벳인지를 알아봄
		boolean result = ((('A' <= c) && (c <= 'Z')) || (('a'<= c) && (c <= 'z')));
		//충분히 활용/응용 가능하다 보임
		System.out.println(result);
	}
}
