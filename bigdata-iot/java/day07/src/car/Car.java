package car;

public class Car {
	int serial;
	String name;
	double size;
	
	static int count;
	//static은 new 클래스가 생기더라도 그대로 > "	클래스변수"
	//serial name size 는 클래스 생길때마다 새로 생기는데
	//count는 영향 안받고 따로 공간생겨서 딱 한번만 생성되어 유지됨 
	
	//암것도 없어도 만들어놓기 > 에러날수있음
	public Car() {	
//		this.name = "KK";
//		this.size = 1000;
		this("KK",1000);
	}
	public Car(String name, double size) {
		this.serial = ++count; 
		this.name = name;
		this.size = size;
	}
	
	public Car(int serial, String name, double size) {
		this.serial = serial;
		this.name = name;
		this.size = size;
	}
	
	//this는 객체의 주소라 보면 ㅇㅇ
	public void setSize(double s) {
		this.size = s;
	}
	
	@Override
	public String toString() {
		return "Car [serial=" + serial + ", name=" + name + ", size=" + size + "]";
	}
}
