package org.boss.recursion;

public class SortedOrNot {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6,4, 5 };
        System.out.println(isSorted(arr, arr.length));
    }

    static boolean isSorted(int[] arr, int size) {
        return solve(arr, size, 0);
    }

    static boolean solve(int[] arr, int size, int idx) {
        if (size == 0 || size == 1)
            return true;
        // if (arr[idx] > arr[idx + 1])
        // return false;
        // else {
        // return solve(arr, size - 1, idx + 1);
        // }
        boolean initial = arr[idx] < arr[idx + 1];
        return initial && solve(arr, size - 1, idx + 1);
    }
}
