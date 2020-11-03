package car2;

public class Car {
	 String name;
	 int gas;
	 int gasSize;
	 double mileage;
	 int distance; 
	 int tollPay;
	 String location;
	 
	public Car() {
	}
	 
	public Car(String name, int gasSize, double mileage) {
		this.name = name;
		this.gas = 0;
		this.gasSize = gasSize;
		this.mileage = mileage;
		this.distance = 0;
		this.tollPay = 0;
		this.location = "Seoul";
	}
	
	public void addGas(double add) {
		if(add > 0) {
			gas += add;
		} else {
			System.out.println("Invalid value ... ");
			return;
		}
	}
	
	public void go(String destination) {
		if(destination == "Busan") {
			this.tollPay = 28700;
			this.distance = 325;
			this.location = "Busan";
			this.gas -= distance/mileage;
		}
		if(destination == "Sokcho") {
			this.tollPay = 11700;
			this.distance = 158;
			this.location = "Sokcho";
			this.gas -= distance/mileage;
		}
		if(destination == "Gwangju") {
			this.tollPay = 17900;
			this.distance = 300;
			this.location = "Gwangju";
			this.gas -= distance/mileage;
		}
	}
	
	public int getTotal() {
		int total = 0;
		total = tollPay + gas*1500;
		return total;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", gas=" + gas + ", gasSize=" + gasSize + ", mileage=" + mileage + ", distance="
				+ distance + ", tollPay=" + tollPay + ", location=" + location + "]";
	}


	
}
