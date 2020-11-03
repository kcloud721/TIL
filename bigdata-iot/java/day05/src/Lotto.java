import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
 
public class Lotto {
    static int USERNUM = 10;
    static int RANGE = 15;
    static int PRICE = 500000000;
 
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        Scanner sc = new Scanner(System.in);
 
        /*
         * players: 사용자들의 입력값이 저장됨. 0번은 사용자 1~99번은 타 사용자 
         * winNum: 당첨번호 
         * playerWin: 식별번호 등
         * winHistory: 1등 몇명 2등 몇명
         */
        int[][] players = new int[USERNUM][6];
        int[] winNum = new int[6];
        int[] playerWin = new int[USERNUM];
        int[] winHistory = new int[4];
 
        /* 사용자 입력 */
        System.out.println("Welcome to Lotto");
        System.out.println("Enter 6 Number(1~45): ");
        for (int i = 0; i < players[0].length; i++) {
            players[0][i] = sc.nextInt();
            
            //////
            for(int j=0 ; j<i ; j++) {
            	if(players[0][j] == players[0][i]) {
            		System.out.println("RETRY");
            		i--;
            		break;
            	}
            }
        }
        System.out.println("\nYour Number is" + Arrays.toString(players[0]));
        
 
        /* 타사용자 랜덤번호 생성 */
        System.out.println("Other player number generating....\n");
        for (int i = 1; i < players.length; i++) {
            players[i] = lotto.makeNumber();
        }
        System.out.println(Arrays.deepToString(players));
 
        /* 당첨번호 생성 */
        winNum = lotto.makeNumber();
        System.out.println("Winning number is " + Arrays.toString(winNum));
 
        /* 각 사용자 등수 지정 */
        for (int i = 0; i < playerWin.length; i++) {
            playerWin[i] = lotto.winningCheck(winNum, players[i]);
        }
        System.out.println(Arrays.toString(playerWin));
 
        /* 몇등 몇명인지 */
        for (int i = 0; i < playerWin.length; i++) {
            if (playerWin[i] != 0)
                winHistory[playerWin[i] - 1]++;
        }
        System.out.println(Arrays.toString(winHistory));
        
        lotto.moneyCal(playerWin, winHistory);
    }
 
    
    
    
    
    
    /* 6자리 랜덤 숫자 생성 */
    public int[] makeNumber() {
        Random r = new Random();
        int[] answer = new int[6];
 
        for (int i = 0; i < answer.length; i++) {
            answer[i] = r.nextInt(RANGE) + 1;
            for (int j = 0; j < i; j++) {
                if (answer[i] == answer[j]) {
                    i--;
                    break;
                }
            }
        }
        return answer;
    }
 
    /*
     * 당첨등수 만듬
     int[] winNum: 당첨번호 int[] myNum: 사용자 번호    
     */
    public int winningCheck(int[] winNum, int[] myNum) {
        int count = 0;
 
        for (int i = 0; i < myNum.length; i++) {
            for (int j = 0; j < winNum.length; j++) {
                if (myNum[i] == winNum[j])
                    count++;
            }
        }
 
        if (count == 6)
            return 1;
        else if (count == 5)
            return 2;
        else if (count == 4)
            return 3;
        else if (count == 3)
            return 4;
        else
            return 0;
    }
 
    public void moneyCal(int[] playerWin, int[] winHistory) {
        long totalPrize = 5000000000L; // 총 상금
        int fourthPrize = 5000; // 4등 상금
        int thirdPrize = 50000; // 3등 상금
 
        // 2등상금 = (총상금 - (4등상금*4등 당첨자 수 ) - (3등상금*3등 당첨자 수))의 25%
        // 1등상금 = (총상금 - (4등상금*4등 당첨자 수 ) - (3등상금*3등 당첨자 수))의 75%
        long secondPrize = (long) 0.25 * (totalPrize - (fourthPrize * winHistory[3]) - (thirdPrize * winHistory[2]));
        long firstPrize = (long) (totalPrize - secondPrize);
 
        System.out.println("이번회차 총 상금은 " + totalPrize + "원 입니다.");
 
        for (int i = 0; i < playerWin.length; i++) {
            if (playerWin[i] == 4)
                System.out.println((i+1)+"번째 축하합니다. 4등입니다. 당첨금액은 " + fourthPrize);
 
            else if (playerWin[i] == 3)
                System.out.println((i+1)+"번째 축하합니다. 3등입니다. 당첨금액은 " + thirdPrize);
 
            else if (playerWin[i] == 2)
                System.out.println((i+1)+"번째 축하합니다. 2등입니다. 당첨금액은 " + (long) secondPrize / winHistory[1]);
 
            else if (playerWin[i] == 1)
                System.out.println((i+1)+"번째 축하합니다. 1등입니다. 당첨금액은 " + (long) firstPrize / winHistory[0]);
        }
 
    }
}