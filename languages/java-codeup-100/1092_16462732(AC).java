import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);
        int maxGys = recursive(max, min, -1);
        int minGbs = n1 * n2 / maxGys;
//        System.out.println(maxGys);
//        System.out.println(minGbs);

        int max2 = Math.max(minGbs, n3);
        int min2 = Math.min(minGbs, n3);
        int maxGys2 = recursive(max2, min2, -1);
        int minGbs2 = max2 * min2 / maxGys2;

        System.out.println(minGbs2);

    }

    public static int recursive(int max, int min, int sur){
        if (sur == 0) {
//            System.out.println(max + " " + min + " " + sur);
            return max;
        }

        sur = max%min;
        max = min;
        min = sur;

        return recursive(max, min, sur);
    }
}

