package org.boss.arrays;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        reverseArrayStartToEnd(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

        // int[] ans = reverseArray(arr);
        // System.out.println(Arrays.toString(ans));

    }

    /*
     * Brute - force approach
     * With Another array to store reversed numbers
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    static int[] reverseArray(int[] arr) {
        int[] ans = new int[arr.length];
        int idx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[idx] = arr[i];
            idx++;
        }
        return ans;
    }

    /*
     * Optimalpproach
     * Let's do it in-place reversal
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    static void reverseArrayInPlace(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n / 2; i++) {
            swap(arr, i, n - i);
        }
    }

    /*
     * Optimalpproach
     * Let's do it in-place reversal using idx variable and decrementing on every
     * iteration
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    static void reverseArrayInPlace2(int[] arr) {
        int idx = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, idx);
            idx--;
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void reverseArrayStartToEnd(int[] arr, int start, int end) {
        int n = end - 1;
        for (int i = start; i < end / 2; i++) {
            swap(arr, i, n - i);
        }
    }
}
