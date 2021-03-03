import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();
        double result = a;

        for (int i = 1; i < n; i++) {
            result *= r;
        }

        NumberFormat f = NumberFormat.getInstance();
        f.setGroupingUsed(false);

        System.out.println(f.format(result));

    }
}
