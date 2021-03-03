import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int cnt = 1;

        while(true){
            if(sum >= n)
                break;
            sum += cnt;
            if(sum%3 != 0)
                System.out.print(sum + " ");

        }

    }
}

