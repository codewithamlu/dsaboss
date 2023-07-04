package org.boss.recursion;

public class Power {
    public static void main(String[] args) {
        // System.out.println(powerRecursive(2, 3));
        System.out.println(myPow(-10, 3));
    }

    static double myPow(double x, int n) {
        long nn = n;
        if (nn < 0)
            nn = -1 * nn;
        double ans = powerLogarithmic(x, nn);
        return n < 0 ? 1 / ans : ans;
    }

    static double powerRecursive(double x, int n) {
        if (n == 0)
            return 1;
        double ans = x * powerRecursive(x, n - 1);
        return ans;
    }

    static double powerLogarithmic(double x, long n) {
        if (n == 0)
            return 1;
        double xTonBy2 = powerLogarithmic(x, n / 2);
        double ans = xTonBy2 * xTonBy2;
        if (n % 2 == 1)
            ans = x * ans;
        return ans;
    }
}
