package org.boss.arrays2;

import java.util.Arrays;

public class ThreeConsecutiveIntegersSumsToK {
    public static void main(String[] args) {
        int num = 33;
        System.out.println(Arrays.toString(findIntegers(num)));
    }
    static long[] findIntegers(int num){
        long n = num / 3;
        long[] ans = new long[3];
        if(n + (n-1) + (n+1) == num){
            ans[0] = n - 1;
            ans[1] = n;
            ans[2] = n + 1;
            return ans;
        }
        else{
            return new long[]{};
        }
    }
}
