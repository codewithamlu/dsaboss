package org.boss.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 10, 98, 23, 8, 54, 78 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = { 10, 98, 23, 8, 54, 78 };
        bubbleSortRec(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /*
     * Compare each element to its next and swap if necessary
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    static void bubbleSortRec(int[] arr) {
        solve(arr, arr.length);
    }

    static void solve(int[] arr, int endIdx) {
        if (endIdx == 0)
            return;

        for (int idx = 0; idx < endIdx - 1; idx++) {
            if (arr[idx] > arr[idx + 1]) {
                int tmp = arr[idx];
                arr[idx] = arr[idx + 1];
                arr[idx + 1] = tmp;
            }
        }
        solve(arr, endIdx - 1);
    }
}
