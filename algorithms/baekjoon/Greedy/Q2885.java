package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int chocolate = 1;
        int cnt = 0;
        int sum = 0;
        int originChocolate = 0;

        while(true){
            if(chocolate >= k)
                break;
            chocolate *= 2;
        }
        originChocolate = chocolate;

        // k가 2의 n제곱일 경우 : 0번 쪼갬
        if(originChocolate == k){
            System.out.println(originChocolate + " " + 0);
            return;
        }

        while(true){
            if(sum == k)
                break;
            if(chocolate/2 + sum <= k) {
                sum += (chocolate / 2);
                chocolate /= 2;
                cnt++;
            } else {
                chocolate /= 2;
                cnt++;
            }
        }

        System.out.println(originChocolate + " " + cnt);

    }

}
