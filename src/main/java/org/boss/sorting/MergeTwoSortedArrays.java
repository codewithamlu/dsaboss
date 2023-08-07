package org.boss.sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 5, 7 };
        int[] arr2 = { 2, 3, 4, 6, 8 };
        // System.out.println(Arrays.toString(merge(arr1, arr2)));
        mergeWithoutExtraSpace1(arr1, arr2);
    }

    static int[] merge(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[] c = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
                k++;
            } else {
                c[k] = b[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            c[k] = a[i];
            i++;
            k++;
        }
        while (j < n) {
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }

    static void mergeWithoutExtraSpace1(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (a[i] > b[j]) {
                int tmp = a[i];
                a[i] = b[j];
                b[j] = tmp;
                i--;
                j++;
            } else
                break;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
