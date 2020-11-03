package tv;

public class DvdTv extends Tv {

	public DvdTv() {
		super();
	}
	public DvdTv(String name, double size) {
		super(name, size);
	}
	
	public void repair() { 	//재정의 override
		System.out.println(name+" Dvd TV Repaired.");

	}
	
	@Override
	public String toString() {
		return "DvdTv [name=" + name + ", size=" + size + "]";
	}

	
}
