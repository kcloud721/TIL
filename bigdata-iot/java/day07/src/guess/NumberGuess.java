package guess;

import java.util.Random;

public class NumberGuess {
	int answer;
	int count;
	int gameCount;
		
	public int makeRandom() {
		gameCount++;
		Random r = new Random();
		this.answer = r.nextInt(100)+1;
		System.out.println(answer);
		return answer;
	}
	
	public String guess(int input) {
		if(input == this.answer) {
			System.out.println("Correct");
			return "TRUE";
		}
		else if(input > this.answer) {
			System.out.println("Higher than answer");
			return "UP";
		}
		else { //if(input < this.answer) 
			System.out.println("Lower than answer");
			return "DOWN";
		}
	}
	
	public void getCount() {
		this.count++;
		return;
	}
	
	public void setCount() {
		this.count = 0;
		return;
	}
}
