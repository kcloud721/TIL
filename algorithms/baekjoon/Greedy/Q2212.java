package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int s[] = new int[n];
        Integer[] diff2 = new Integer[n-1];

        int space = k-1;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        Arrays.sort(s);

        for (int i = 0; i < s.length-1; i++) {
            diff2[i] = s[i+1] - s[i];

        }

        Arrays.sort(diff2, Collections.reverseOrder());

        for (int i = space; i < n-1; i++) {
            answer += diff2[i];
        }

        System.out.println(answer);
    }

}
