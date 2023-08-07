package org.boss.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // Divide and Conquer
    static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    static void merge(int[] arr, int si, int mid, int ei) {
        int[] ans = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                ans[k] = arr[i];
                i++;
                k++;
            } else {
                ans[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            ans[k] = arr[i];
            i++;
            k++;
        }
        while (j <= ei) {
            ans[k] = arr[j];
            j++;
            k++;
        }

        for(int x = 0, y = si; x < ans.length; x++, y++){
            arr[y] = ans[x];
        }
    }
}

