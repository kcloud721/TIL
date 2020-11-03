package gene;

public class Candy extends Product{
	private String name;
	private int weight;
	public Candy() {
	}
	public Candy(String name, int price, int weight) {
		super(price);
		this.name = name;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Candy [name=" + name + ", price=" + price + ", weight=" + weight + "]";
	}
	
	
}
