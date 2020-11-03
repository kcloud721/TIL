package food;

public class Hamburger extends Western {
	int time;
	
	public Hamburger() {}
	public Hamburger(int cal, int price, String fork) {
		super(cal, price, fork);
	}
	
	public Hamburger(int cal, int price, String fork, int time) {
		this.cal = cal;
		this.price = price;
		this.fork = fork;
		this.time = time;
	}
	
	@Override
	public void servingTime() {
		System.out.println("serving time: "+time);
		return;
	}

	@Override
	public double pricePerCal(int cal, int price) {
		double ppc = price/cal;
		return ppc;
	}
	@Override
	public String toString() {
		return "Hamburger [time=" + time + ", cal=" + cal + ", price=" + price + ", fork=" + fork + "]";
	}
	

}
