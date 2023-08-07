package org.boss.maths;

import java.util.Arrays;

public class CountPrimes1ToN {
    public static void main(String[] args) {
        int n = 50;
        System.out.println(countPrimes(n));
    }
    static int countPrimes(int n){
        if(n == 0)
            return 0;
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes,true);
        int cnt = 0;
        primes[0] = primes[1] = false;

        for(int i = 2; i < n; i++){
            if(primes[i]) {
                cnt++;
                for(int j = 2 * i; j < n; j = j + i){
                    primes[j] = false;
                }
            }
        }
        return cnt;
    }
}
