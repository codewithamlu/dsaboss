package org.boss.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 2;

        // Convert value of k into 0 - 5 by taking modulus
        k %= arr.length;

        // If k is negative , add n to k so that it comes in our range
        if (k < 0)
            k += arr.length;

        // rotateUsingTemp(arr, k);
        // rotateCyclicly(arr, k);
        rotateByReverse(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * Brute - force approach
     * Make temp array of size k and store first k+1 elements in it
     * Shift last k elements to as per rotation to start of array
     * At last, elements from temp in arr starting from n-k position of arr by x=0
     * position of temp
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(k)
     */
    static void rotateUsingTemp(int[] arr, int k) {
        int n = arr.length - 1;
        int[] temp = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            temp[i] = arr[i];
        }
        int x = k + 1;
        for (int i = 0; x <= n; i++) {
            arr[i] = arr[x++];
        }
        x = 0;
        for (int i = n - k; i <= n; i++) {
            arr[i] = temp[x++];
        }
    }

    /*
     * Another approach
     * Store last element in temporary variable
     * Loop until 0 to k - 1 and rotate array elements from last one by one
     * Then store last element at 0th index
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    static void rotateCyclicly(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            cyclicRotateOneByOne(arr);
        }
    }

    static void cyclicRotateOneByOne(int[] arr) {
        int n = arr.length;
        int last = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    static void rotateByReverse(int[] arr, int k) {
        reverseArrayStartToEnd(arr, 0, arr.length);
        reverseArrayStartToEnd(arr, 0, k);
        reverseArrayStartToEnd(arr, k, arr.length);
    }

    static void reverseArrayStartToEnd(int[] arr, int start, int end) {
        int n = end - 1;
        for (int i = start; i < end / 2; i++) {
            swap(arr, i, n - i);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
