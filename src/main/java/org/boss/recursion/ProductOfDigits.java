package org.boss.recursion;

public class ProductOfDigits {
    public static void main(String[] args) {
        int n = 334;
        System.out.println(product(n));
    }

    static int product(int n) {
        if (n < 1) {
            // Multiplicative Identity
            return 1;
        }
        // if (n % 10 == n) {
        // // Multiplicative Identity
        // return n;
        // }
        int last = n % 10;
        int smallSum = product((int) n / 10);
        return last * smallSum;
    }
}
