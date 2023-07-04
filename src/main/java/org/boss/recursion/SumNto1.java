package org.boss.recursion;

public class SumNto1 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sum(n));
    }

    static int sum(int n) {
        if (n < 1)
            return 0;
        int smallSum = sum(n - 1);
        return n + smallSum;
    }
}
