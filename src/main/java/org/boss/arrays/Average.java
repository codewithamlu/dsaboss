package org.boss.arrays;

public class Average {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(getAverage(arr));
    }

    /*
     * Brute - force approach
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    static double getAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double avg = sum / arr.length;
        return avg;
    }
}
