package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int[] chains = new int[n];

        for (int i = 0; i < n; i++) {
            chains[i] = sc.nextInt();
        }

        Arrays.sort(chains);
        int i = 0;
        int min = chains[i];
        int num_chains = chains.length - 1;

        while(true){
            if(n == 2){
                result = 1;
                break;
            } else if(num_chains <= min){
                result = num_chains;
                break;
            }
            i++;
            result += min;
            min = chains[i];
            num_chains--;

        }

        System.out.println(result);
    }

}
