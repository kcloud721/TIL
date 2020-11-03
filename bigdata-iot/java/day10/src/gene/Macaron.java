package gene;

public class Macaron extends Product{
	private String name;
	//private int price;
	public Macaron() {
	}
	public Macaron(String name, int price) {
		super(price);
		this.name = name;
	}
	@Override
	public String toString() {
		return "Macaron [name=" + name + ", price=" + price + "]";
	}
	
	
}
