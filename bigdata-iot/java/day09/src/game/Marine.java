package game;

public class Marine extends Unit {

	// x, y, name
	
	public Marine() {
		super();
	}	
	public Marine(int x, int y, String name) {
		super(x, y, name);
	}
	public Marine(String name) {
		super(name);
	}

	@Override
	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	@Override
	public String toString() {
		return "Marine [x=" + x + ", y=" + y + ", name=" + name + "]";
	}
	public void stimPack() {
		System.out.println(name+" Stimpack..");
	}
	@Override
	void changeMode() {
		// TODO Auto-generated method stub
		
	}

}
