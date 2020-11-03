package oppLotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoApp {

	public static void main(String[] args) {
		Lotto l = new Lotto();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Lotto");
        System.out.println("Enter 6 Number(1~45): ");
        
        for (int i = 0; i < l.players[0].length; i++) {
            l.players[0][i] = sc.nextInt();          
            for(int j=0 ; j<i ; j++) { //占쌩븝옙占쏙옙占쏙옙
            	if(l.players[0][j] == l.players[0][i]) {
            		System.out.println("RETRY");
            		i--;
            		break;
            	}
            }
        }
        System.out.println("\nYour Number " + Arrays.toString(l.players[0]));
        
        l.winNum = l.makeNumber();
        l.players = l.setPlayers();
        
        for(int i=0 ; i<l.USERNUM ; i++) {
        	l.playerWin[i] = l.winningCheck(i);
        	//playerWin占쏙옙 占쌘깍옙 占쏙옙占� 占쏙옙占쏙옙
        }
        
        // �떦泥⑥옄 移댁슫�듃.. 
        l.winInfo();
        
        //�긽湲덇퀎�궛
        l.moneyCal(l.playerWin, l.winHistory);
        
        //理쒖쥌寃곌낵(�떦泥⑥옄+�떦泥④툑�븸)
        
        System.out.println(Arrays.toString(l.winNum));
        System.out.println(Arrays.deepToString(l.players));
        System.out.println(Arrays.toString(l.playerWin));
        System.out.println(Arrays.toString(l.winHistory));
	}
}
