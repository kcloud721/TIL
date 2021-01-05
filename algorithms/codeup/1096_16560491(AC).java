import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arr[][] = new int[19][19];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()-1][sc.nextInt()-1] = 1;
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
