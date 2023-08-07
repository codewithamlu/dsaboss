package org.boss.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {15, 24, 3, 22, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        // code here
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    static int partition(int[] arr, int low, int high) {

        int tar = arr[high];
        int i = low, j = low;
        while (i <= high) {
            if (arr[i] <= tar) {
                if (i != j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                i++;
                j++;

            } else
                i++;
        }
        return j - 1;
    }
}
