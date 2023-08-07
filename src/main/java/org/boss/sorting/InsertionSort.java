package org.boss.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 10, 98, 23, 8, 54, 78 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = { 10, 98, 23, 8, 54, 78 };
        insertionSortRec(arr2);
        // System.out.println(Arrays.toString(arr2));
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            insert(arr, i, i);
        }
    }

    static void insert(int[] arr, int pos, int endIndex) {
        for (int j = 0; j <= endIndex; j++) {
            if (arr[pos] < arr[j]) {
                int tmp = arr[pos];
                arr[pos] = arr[j];
                arr[j] = tmp;
            }
        }
    }

    static void insertionSortRec(int[] arr) {
    }
}
