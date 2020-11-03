package food;

public abstract class Western extends Food {
	protected int cal;
	protected int price;
	String fork;
	
	public Western() {}
	public Western(int cal, int price) {		
		super(cal, price);
	}
	
	public Western(int cal, int price, String fork) {
		this.cal = cal;
		this.price = price;
		this.fork = fork;
	}
	
	abstract public void servingTime();
	abstract public double pricePerCal(int cal, int price);

	public void drinkBeer() {
		System.out.println("Drink beer");
	}
	public void servePickle() {
		System.out.println("with pickle");
	}
	@Override
	public String toString() {
		return "Western [cal=" + cal + ", price=" + price + ", fork=" + fork + "]";
	}
	
}
