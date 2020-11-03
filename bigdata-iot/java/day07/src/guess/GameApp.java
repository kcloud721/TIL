//package: guess
//1. Number Guess Game OPP(객체지향)로 설계하시오 (starUML)
//2. GameApp.java를 만들어서 통합하시오

package guess;

import java.util.Scanner;

public class GameApp {
	public static void main(String[] args) {
		NumberGuess n = new NumberGuess();
		Scanner s = new Scanner(System.in);
		while(true) {
			n.answer = n.makeRandom();
			String check =""; 
			String yn =""; 
			
			while(true) {
				int input = Integer.parseInt(s.nextLine());
				n.getCount();
				check = n.guess(input);
				
				if(check == "TRUE") {
					System.out.println("Count: "+ n.count);
					System.out.println("RETRY? (y/n)");
					yn = s.nextLine();
					break;
				}
				else
					System.out.println("RETRY");
			}
			
			if(yn.equals("n")) {
				System.out.println("End .. Total game count is "+ n.gameCount);
				break;
			} else {
				n.setCount();
			}
		}
	}
}
