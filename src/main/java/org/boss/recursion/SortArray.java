package org.boss.recursion;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 2 };
        System.out.println(Arrays.toString(sortArr(arr, arr.length)));
    }

    static int[] sortArr(int[] arr, int n) {
        sort(arr, 0, n);
        return arr;
    }

    static void sort(int[] arr, int low, int high) {
        if (low == high)
            return;
        sort(arr, low + 1, high);
        insertRecursive(arr, low, low + 1);
    }

    static void insert(int[] arr, int idx, int start) {
        while (idx + 1 < arr.length) {
            if (arr[idx] > arr[idx + 1]) {
                int temp = arr[idx];
                arr[idx] = arr[idx + 1];
                arr[idx + 1] = temp;
                idx++;
            } else
                break;
        }
    }

    static void insertRecursive(int[] arr, int idx, int start) {
        if (start == arr.length)
            return;
        if (arr[idx] <= arr[idx + 1])
            return;
        int temp = arr[idx];
        arr[idx] = arr[idx + 1];
        arr[idx + 1] = temp;
        idx++;
        insert(arr, idx, start + 1);
    }
}
