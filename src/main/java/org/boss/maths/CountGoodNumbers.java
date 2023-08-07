package org.boss.maths;

public class CountGoodNumbers {

    public static void main(String[] args) {
        int n = 50;
        System.out.println(countGoodNumbers2(n));
    }

    static int countGoodNumbers(long n) {
        int MOD = 1_000_000_007;
        long result = n % 2 == 0 ? 1:5;
        long x = 20;
        for(long i = n / 2; i > 0; i /= 2){
            if(i % 2 == 1) result = result * x  % MOD;
            x = x * x % MOD;
        }

        return (int)result;
    }
    static int countGoodNumbers2(long n) {
        int MOD = 1_000_000_007;
        long oddPos = n / 2;
        long evenPos = n - oddPos;
        long ans = (power(5, evenPos) * power(4, oddPos))% MOD;
        return (int)ans ;
    }

    static long power(long x, long n) {
        int MOD = 1_000_000_007;
        if (n == 0)
            return 1;
        long xTonBy2 = power(x, n / 2);
        long ans =( xTonBy2 * xTonBy2 ) % MOD;
        if (n % 2 == 1)
            ans = (x * ans ) % MOD;
        return ans;
    }
}
