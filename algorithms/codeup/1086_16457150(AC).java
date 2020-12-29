import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextInt();
        double h = sc.nextInt();
        double b = sc.nextInt();

        System.out.println(String.format("%.2f", w*h*b/8/(1024*1024)) + " MB");


    }
}

