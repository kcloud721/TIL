package calc;

public class Calc {
	
	// "static" 
	// 굳이 new로 객체 생성하지 않아도 함수의 기능 사용 가능
	
	public static int add(int a, int b) {
		int add = 0;
		add = a+b;
		return add;
	}
	
	//자바의 "오버로드" > 함수 이름 똑같아 "add"
	//모든 케이스를 만들 수 있음
	public static double add(int a, double b) {
		double add = 0;
		add = a+b;
		return add;
	}
	
	public static double add(double a, int b) {
		double add = 0;
		add = a+b;
		return add;
	}

	public static double add(double a, double b) {
		double add = 0;
		add = a+b;
		return add;
	}	
	
}
