package game;

public class Tank extends Unit {

	public Tank() {
		super();
	}

	public Tank(int x, int y, String name) {
		super(x, y, name);
	}

	public Tank(String name) {
		super(name);
	}

	@Override
	void move(int x, int y) {
		this.x = x + 3;
		this.y = y + 3;
	}
	public void changeMode() {
		System.out.println(name+" chageMode");
	}

	@Override
	void stimPack() {
		// TODO Auto-generated method stub
		
	}
}




