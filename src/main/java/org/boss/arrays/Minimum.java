package org.boss.arrays;

public class Minimum {
    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5 };
        System.out.println(getMinimum(arr));
    }

    /*
     * Brute - force approach
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    static int getMinimum(int[] arr) {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }
}
