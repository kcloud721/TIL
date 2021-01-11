package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int usedGori = 0;
        int[] chains = new int[n];

        for (int i = 0; i < n; i++) {
            chains[i] = sc.nextInt();
        }

        Arrays.sort(chains);
        int i = 0;  // 고리 빼서 사용할 체인 위치
        int indexOfMaster = chains.length - 1;  // 이어붙일 체인 위치


        while(true){
            if(chains[i] == 0) {
                i++;
            }
            if(i >= indexOfMaster){
                break;
            }

            usedGori++;
            indexOfMaster--;
            chains[i]--;

        }

        System.out.println(usedGori);
    }

}
