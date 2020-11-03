package food;

public abstract class Food {
	protected int cal;
	protected int price;
	public Food() {
	}
	public Food(int cal, int price) {
		this.cal = cal;
		this.price = price;
	}
	
	abstract public void servingTime();
	abstract public double pricePerCal(int cal, int price);
	

}
