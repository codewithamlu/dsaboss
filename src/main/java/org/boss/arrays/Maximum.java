package org.boss.arrays;

public class Maximum {
    public static void main(String[] args) {
        int[] arr = { 11, 2, -3, 4, 5 };
        System.out.println(getMaximum(arr));
    }

    /*
     * Brute - force approach
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    static int getMaximum(int[] arr) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        return maximum;
    }
}
