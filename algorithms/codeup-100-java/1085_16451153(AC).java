import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double h = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        double s = sc.nextInt();

        System.out.println(String.format("%.1f", h*b*c*s/8/(1024*1024)) + " MB");


    }
}

