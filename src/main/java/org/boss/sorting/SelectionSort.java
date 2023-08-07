package org.boss.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 10, 98, 23, 8, 54, 78 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = { 10, 98, 23, 8, 54, 78 };
        selectionSortRec(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = select(arr, i);
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }

    static int select(int[] arr, int start) {
        int minIdx = start;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < arr[minIdx])
                minIdx = i;
        }
        return minIdx;
    }

    static void selectionSortRec(int[] arr) {
        solve(arr, 0, 0);
    }

    static void solve(int[] arr, int i, int start) {
        if (i == arr.length )
            return;
        int minIdx = select(arr, start);
        int tmp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = tmp;

        solve(arr, i + 1, i + 1);
    }
}
