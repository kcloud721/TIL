import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        
        int arr[][] = new int[h][w];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();   // 길이 
            int d = sc.nextInt();   // 0: 가로, 1: 세로
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;

            for (int j = 0; j < l; j++) {
                if(d == 0){
                    arr[x][y+j] = switchVal(arr[x][y+j]);
                } else{
                    arr[x+j][y] = switchVal(arr[x+j][y]);
                }
            }
        }

        // print reuslt
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        
        
                
    }

    private static int switchVal(int n) {
        if(n == 1)
            return 0;
        else
            return 1;
    }

}

