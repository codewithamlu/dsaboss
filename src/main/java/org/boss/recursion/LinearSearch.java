package org.boss.recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5};
        System.out.println(search(arr, arr.length,10));
    }

    static boolean search(int[] arr, int size, int tar) {
        return solve(arr, size, tar, 0);
    }

    static private boolean solve(int[] arr, int size, int tar, int idx) {
        if (size == 0)
            return false;
        boolean initial = arr[idx] == tar;
        return initial || solve(arr, size - 1, tar, idx + 1);

    }
}
