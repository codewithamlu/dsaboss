package org.boss.maths;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args) {
        int num = 16;
        primeFactors(num);
    }

    static void primeFactors(int n) {
        int i = 2;
        int num = n;

        List<Integer> list = new ArrayList<>();
        while(i * i <= num){
            while(num % i == 0){
                num /= i;
                list.add(i);
            }
            i++;
        }
        if(num != 1){
            list.add(num);
        }
        System.out.println(list);
    }
}
