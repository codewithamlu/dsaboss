package org.boss.recursion;

public class StepsReduceToZero {
    public static void main(String[] args) {

    }

    static int numberOfSteps(int num) {
        return solve(num, 0);
    }

    static int solve(int n, int steps) {
        if (n == 0) {
            return steps;
        }
        if (n % 2 == 0) {
            return solve((int) n / 2, steps + 1);
        }
        return solve(n - 1, steps + 1);
    }
}
