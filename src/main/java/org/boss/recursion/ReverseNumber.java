package org.boss.recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(reverse2(n));
    }

    static int revSum = 0;

    static int reverse1(int n) {
        reverseNum(n);
        return revSum;
    }

    static void reverseNum(int n) {
        if (n == 0) {
            return;
        }
        int digit = n % 10;
        revSum = revSum * 10 + digit;
        reverseNum(n / 10);
    }

    static int reverse2(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n % 10 == n)
            return n;
        int rem = n % 10;
        int smallerAns = helper(n / 10, digits - 1);
        return rem * (int) (Math.pow(10, digits - 1)) + smallerAns;
    }
}
