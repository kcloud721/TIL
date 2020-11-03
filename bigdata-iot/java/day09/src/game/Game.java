package game;

public class Game {

	public static void main(String[] args) {
		Unit units[] = new Unit[4];
		units[0] = new Marine(10,10,"Marine1");
		units[1] = new Marine(10,10,"Marine2");
		units[2] = new Marine(10,10,"Tank1");
		units[3] = new Marine(10,10,"Tank2");
		
		for(Unit u:units) {
			System.out.println(u);
		}
		for(Unit u:units) {
			u.move(5, 5);
		}
		for(Unit u:units) {
			if(u instanceof Marine) {
				((Marine) u).stimPack();
			} else if(u instanceof Marine) {
				((Tank) u).changeMode();
			}
		}
	}

}
