import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arr[][] = new int[19][19];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            for (int j = 0; j < 19; j++) {
                arr[a][j] = switchVal(arr[a][j]);
                arr[j][b] = switchVal(arr[j][b]);
            }


        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
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

