package car;

public class Car {
	String name;
	String color;
	int size;
	int gasSize;
	int gas;
	double mileage; //연비
	
	public Car() {
	}
	
	public Car(String name, String color, int gasSize, double mileage) {
		this.name = name;
		this.color = color;
		this.size = 2000;
		this.gas = 0;
		this.gasSize = gasSize;
		this.mileage = mileage;
	}
	
	public int getGas() { //return 타입이라 void 아니고 데이터형
		return this.gas;
	}
	
	public void addGas(int addgas) {
		if(gas+addgas <= gasSize && addgas>0) {
			this.gas += addgas;
		} else {
			System.out.println("Alert: Exception ...");
		}
	}
	
	public void go(double distance) {
		if (distance < 0) {
			System.out.println("Invaild Distance");
			return;
		} 
		if (this.gas == 0) {
			System.out.println("Empty gas ...");
			return;
		} else {
			this.gas -= (distance/this.mileage);
			System.out.println("Go: " + this.name);
		}

	}
	public void stop( ) {
		System.out.println("Stop: "+this.name);		
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + ", gasSize=" + gasSize + ", gas=" + gas
				+ ", mileage=" + mileage + "]";
	}
	
}
