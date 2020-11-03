package tv;

public class LcdTv extends Tv {

	public LcdTv() {
		super();
	}
	public LcdTv(String name, double size) {
		super(name, size);
	}
	
	public void repair() { 	//재정의 override
		System.out.println(name+" Lcd TV Repaired.");

	}
	
	@Override
	public String toString() {
		return "LcdTv [name=" + name + ", size=" + size + "]";
	}

	
}
