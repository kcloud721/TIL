import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();
        long result = a;

        for (int i = 1; i < n; i++) {
            result = (result * m) + d;

        }

        NumberFormat f = NumberFormat.getInstance();
        f.setGroupingUsed(false);

        System.out.println(f.format(result));

    }
}
