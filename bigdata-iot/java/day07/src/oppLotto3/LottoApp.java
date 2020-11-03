package oppLotto3;

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
            for(int j=0 ; j<i ; j++) { //? ?Œ©ë¸ì˜™? ?™?˜™? ?™?˜™
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
        	//playerWin? ?™?˜™ ? ?Œ˜ê¹ì˜™ ? ?™?˜™? ï¿? ? ?™?˜™? ?™?˜™
        }
        
        // ï¿½ë–¦ï§£â‘¥?˜„ ç§»ëŒ?Š«ï¿½ë“ƒ.. 
        l.winInfo();
        
        //ï¿½ê¸½æ¹²ë‡?Žï¿½ê¶?
        l.moneyCal(l.playerWin, l.winHistory);
        
        //ï§¤ì’–ì¥Œå¯ƒê³Œë‚µ(ï¿½ë–¦ï§£â‘¥?˜„+ï¿½ë–¦ï§£â‘£?ˆ‘ï¿½ë¸¸)
        
        System.out.println(Arrays.toString(l.winNum));
        System.out.println(Arrays.deepToString(l.players));
        System.out.println(Arrays.toString(l.playerWin));
        System.out.println(Arrays.toString(l.winHistory));
	}
}
