package org.boss.recursion;

public class IncreasingDecreasing {
    public static void main(String[] args) {
        printIncreasingDecreasing(5);
    }

    static void printIncreasingDecreasing(int n) {
        if (n == 0)
            return;
        
        System.out.println(n);
        printIncreasingDecreasing(n - 1);
        System.out.println(n);
    }
}
