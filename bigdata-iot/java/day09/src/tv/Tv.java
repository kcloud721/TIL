package tv;

public class Tv /* extends Object 생략되어있음 */{
	String name;
	double size;
	
	public Tv() {
	}
	public Tv(String name, double size) {
		this.name = name;
		this.size = size;
	}
	
	public void repair() {
		System.out.println(name+" Tv Repaired.");
	}
	
	@Override
	public String toString() {
		return "Tv [name=" + name + ", size=" + size + "]";
	}

}
