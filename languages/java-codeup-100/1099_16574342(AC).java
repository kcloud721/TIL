import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int headX = 1;
        int headY = 1;

        while(true){
            // 먹이를 찾았을 때
            if(arr[headY][headX] == 2) {
                arr[headY][headX] = 9;
                break;
            }
//            } else if(arr[headY][headX+1] == 2) {
//                arr[headY][headX] = 9;
//                arr[headY][headX+1] = 9;
//                break;
//            } else if (arr[headY+1][headX] == 2){
//                arr[headY][headX] = 9;
//                arr[headY+1][headX] = 9;
//                break;
//            }

            if(arr[headY][headX+1] != 1){
                if(arr[headY][headX+1] == 2){
                    arr[headY][headX] = 9;
                    arr[headY][headX+1] = 9;
                    break;
                } else { // case: 0
                    arr[headY][headX] = 9;
                    headX++;
                }
            } else if (arr[headY+1][headX] != 1){
                if(arr[headY+1][headX] == 2){
                    arr[headY][headX] = 9;
                    arr[headY+1][headX] = 9;
                    break;
                } else {
                    arr[headY][headX] = 9;
                    headY++;
                }
            } else {    // 막혔을 때
                arr[headY][headX] = 9;
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
                
    }

}

