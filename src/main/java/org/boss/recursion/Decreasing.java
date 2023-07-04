package org.boss.recursion;

public class Decreasing {
    public static void main(String[] args) {
        decreasing(5);
    }

    static void decreasing(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        decreasing(n - 1);
    }
}
