package oppLotto2;
 
import java.util.*;
 
public class Lotto {
 
    int[] answer = new int[6];
    int[][] player = new int[100][6]; // All user's data. user#1 = player
    int[] playerWinInfo = new int[100]; // All user's winChecked data.
    int[] winnerSet = new int[5];
    long[] winnerPrice = new long[5];
            
    static int PRICE = 500_000_000;
    
    Random r = new Random();
    
    public Lotto() {
    }
    
    public int[] makeRandomnumber() {
        int [] number = new int[6];
        
        for (int index = 0; index < number.length; index++) {
            number[index] = r.nextInt(44) + 1;
            for (int in_index = 0; in_index < index; in_index++) {
                if (number[index] == number[in_index]) {
                    index--;
                    break;
                }
            }
            
        }
        return number;
    }
    
    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
    
    public void setPlayer(int i, int[] singleplayer) {
        this.player[i] = singleplayer;
    }
    
    public int winningCheck(int[] number) {
        int count = 0;
        
        for (int index = 0; index < number.length; index++) {
            for (int in_index = 0; in_index < answer.length; in_index++) {
                if (answer[in_index] == number[index]) {
                    count++;
                }
            }
            
        }
        if (count  > 2) {
            return 7 - count;
        }
        else {
            return 0;
        }
    }
    
    public void setWinner() {
        for (int person = 0; person < 100; person++) {
            this.playerWinInfo[person] = winningCheck(player[person]);
        }
    }
    
    public void moneyCal() {
        for (int person = 0; person < 100; person++) {
            this.winnerSet[playerWinInfo[person]]++;
        }
        this.winnerPrice[4] = 5000;
        this.winnerPrice[3] = 50000;
        
        long prize_2 = (long) (0.25 *(PRICE - (winnerPrice[4]*winnerSet[4] + winnerPrice[3]*winnerSet[3])));
        this.winnerPrice[2] = (winnerSet[2] != 0) ? (prize_2 / winnerSet[2]) : (winnerPrice[4]*winnerSet[4] + winnerPrice[3]*winnerSet[3]);
        
        long prize_1 = (PRICE - winnerPrice[2]);
        this.winnerPrice[1] = (winnerSet[1] != 0) ? (prize_1 / winnerSet[1]) : prize_1;
    }
}
 