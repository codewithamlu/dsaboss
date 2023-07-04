package org.boss.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 987654;
        System.out.println(sum(n));
    }

    static int sum(int n) {
        if (n < 1) {
            // Additive Identity
            return 0;
        }
        int last = n % 10;
        int smallSum = sum((int) n / 10);
        return last + smallSum;
    }
}
