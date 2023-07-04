package org.boss.recursion;

public class CountZeroes {
    public static void main(String[] args) {
        int n = 1001200;
        System.out.println(count(n));
    }

    static int count(int n) {
        return solve(n, 0);
    }

    private static int solve(int n, int count) {
        if (n == 0)
            return count;

        int rem = n % 10;
        if (rem == 0) {
            return solve(n / 10, count + 1);
        }
        return solve(n / 10, count);
    }
}
